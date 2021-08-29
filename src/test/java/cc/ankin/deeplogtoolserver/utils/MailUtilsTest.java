package cc.ankin.deeplogtoolserver.utils;

import cc.ankin.deeplogtoolserver.mapper.UserMapper;
import cc.ankin.deeplogtoolserver.pojo.Log;
import cc.ankin.deeplogtoolserver.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MailUtilsTest {
    @Test
    public void getLogListByUserId(){
        List<Log> logList = MainUtils.getInstance().getLogListByUserId("33408e4b-e6b4-4fa9-9d6c-4a549827648a");
        System.out.println(logList);

    }
}
