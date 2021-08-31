package cc.ankin.deeplogtoolserver.mapper;

import cc.ankin.deeplogtoolserver.pojo.Log;
import cc.ankin.deeplogtoolserver.pojo.User;
import cc.ankin.deeplogtoolserver.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class LogMapperTest {

    @Test
    public void getLogListByUserId(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logList = logMapper.getLogListByUserId("b01f9e86-4542-4da4-a5e7-68c257befde6");

        System.out.println(logList);
        for (Log log : logList){
            System.out.println(log);
        }

        sqlSession.close();
    }
}
