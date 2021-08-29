package cc.ankin.deeplogtoolserver.utils;

import cc.ankin.deeplogtoolserver.mapper.ConfigMapper;
import cc.ankin.deeplogtoolserver.mapper.LogDetailMapper;
import cc.ankin.deeplogtoolserver.mapper.LogMapper;
import cc.ankin.deeplogtoolserver.mapper.UserMapper;
import cc.ankin.deeplogtoolserver.pojo.Config;
import cc.ankin.deeplogtoolserver.pojo.Log;
import cc.ankin.deeplogtoolserver.pojo.LogDetail;
import cc.ankin.deeplogtoolserver.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import javax.xml.ws.ResponseWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainUtils {

    private String randomCode = "";
    private static MainUtils instance = new MainUtils();

    private MainUtils() {
        randomCode = ToolUtils.getRandomInteger(2147483600) + "DLT";

    }

    public static MainUtils getInstance() {
        return instance;
    }

    public User getUserByUsername(String username) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername(username);
        sqlSession.close();
        return user;
    }


    /*
    Return Code:
        0 密码正确
        1 密码错误
        2 用户名不存在
     */
    public Integer checkPassword(String username, String password) {

        User user = getUserByUsername(username);
        if (user == null) {
            return 2;
        } else if (!user.getPassword().equals(password)) {
            return 1;
        } else {
            return 0;
        }
    }


    public List<Log> getLogListByUserId(String userId) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logList = logMapper.getLogListByUserId(userId);
        sqlSession.close();
        return logList;

    }

    @ResponseBody
    @RequestMapping("/createNewLog")
    public String createNewLog(String title, String comments, Long timestamp) {
        String id = ToolUtils.getRandomUUID();

        Log log = new Log(
                id,
                whoAmI().getId(),
                timestamp,
                title,
                comments,
                0
        );

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        logMapper.insertLog(log);
        sqlSession.commit();
        sqlSession.close();

        return id;
    }


    @ResponseBody
    @RequestMapping("/uploadLogDetail")
    public String uploadLogDetail(String logId, Integer epoch, Double accuracy,
                                   Double trainLoss, Double testLoss, Double learningRate,
                                   Double startTime, Double trainTime, Double testTime){

        String id = ToolUtils.getRandomUUID();

        LogDetail logDetail = new LogDetail(
                id,
                logId,
                epoch,
                accuracy,
                trainLoss,
                testLoss,
                learningRate,
                startTime,
                trainTime,
                testTime
        );

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LogDetailMapper logDetailMapper = sqlSession.getMapper(LogDetailMapper.class);
        logDetailMapper.insertLogDetail(logDetail);
        sqlSession.commit();
        sqlSession.close();

        return id;
    }

    @ResponseBody
    @RequestMapping("/uploadConfig")
    public Integer uploadConfig(String logId, String configText){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ConfigMapper configMapper = sqlSession.getMapper(ConfigMapper.class);

        String[] configTextArray = configText.split("\n");
        for (String configLine:configTextArray) {
            String[] configTag = configLine.split(":");
            Config config = new Config(
                    ToolUtils.getRandomUUID(),
                    logId,
                    configTag[0],
                    configTag[1]
            );

            configMapper.insertConfig(config);

        }


        sqlSession.commit();
        sqlSession.close();

        return 0;
    }


    @ResponseBody
    @RequestMapping("/whoAmI")
    public User whoAmI(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @ResponseBody
    @RequestMapping("/checkLogin")
    public Integer checkLogin(){
        return 0;
    }

    @ResponseBody
    @RequestMapping("/doneLog")
    public Integer doneLog(String logId){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);

        Log log = logMapper.getLogById(logId);
        log.setDone(1);
        logMapper.updateLog(log);

        sqlSession.commit();
        sqlSession.close();

        return 0;
    }



}
