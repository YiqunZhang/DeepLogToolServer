package cc.ankin.deeplogtoolserver.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

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

    public static String getRandomUUID(){
        return UUID.randomUUID().toString();
    }

    public static Long getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis()).getTime();
    }

    public static String getTextTime(Long timestamp){
        Date data = new Date(timestamp);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(data);

        return dateString;
    }

}
