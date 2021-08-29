package cc.ankin.deeplogtoolserver.utils;

import cc.ankin.deeplogtoolserver.mapper.LogMapper;
import cc.ankin.deeplogtoolserver.mapper.UserMapper;
import cc.ankin.deeplogtoolserver.pojo.Log;
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


    @ResponseBody
    @RequestMapping("/signIn")
    public Object signIn(String username, String password) {
        Integer res = MainUtils.getInstance().checkPassword(username, password);
        if (res == 0) {
            return res;
        } else {
            return res;
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
    public Object createNewLog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Log log = new Log();


        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        logMapper.insertLog(log);
        sqlSession.close();

        return "";

    }

    @ResponseBody
    @RequestMapping("/a")
    public Object a(){
        return getCurrentUser();
    }

    public User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }



}
