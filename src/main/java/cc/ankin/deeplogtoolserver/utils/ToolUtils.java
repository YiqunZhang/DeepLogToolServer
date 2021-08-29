package cc.ankin.deeplogtoolserver.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

public class ToolUtils {

    private static ToolUtils instance = new ToolUtils();
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private ToolUtils() {}

    public static Integer getRandomInteger(Integer maxNotInclude) {
        //不包括最大值
        Random r = new Random();
        return r.nextInt(maxNotInclude);
    }

    public static String pwdEncoder(String pwd){
        return bCryptPasswordEncoder.encode(pwd);
    }


}
