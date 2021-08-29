package cc.ankin.deeplogtoolserver.mapper;

import cc.ankin.deeplogtoolserver.pojo.User;
import cc.ankin.deeplogtoolserver.utils.MybatisUtils;
import cc.ankin.deeplogtoolserver.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.UUID;


public class UserMapperTest {
    @Test
    public void getUserList(){
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();


    }

    @Test
    public void getUserByUsername(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername("15098144981");

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById("adb07877-df09-49f1-b5d6-de260c90b6fa");

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void insertUser(){
        SqlSession  sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(UUID.randomUUID().toString(),"15098144981","123");
        userMapper.insetUser(user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User("adb07877-df09-49f1-b5d6-de260c90b6fa","13395464635","456"));
        sqlSession.commit();
        sqlSession.close();
    }
}
