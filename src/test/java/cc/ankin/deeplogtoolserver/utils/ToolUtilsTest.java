package cc.ankin.deeplogtoolserver.utils;

import org.junit.Test;

public class ToolUtilsTest {
    @Test
    public void pwdEncoder(){
        String pwd = ToolUtils.pwdEncoder("123");
        System.out.println(pwd);
    }

    @Test
    public void getCurrentTimestamp(){
        Long timestamp = ToolUtils.getCurrentTimestamp();
        System.out.println(timestamp);
    }

}
