package cc.ankin.deeplogtoolserver.mapper;

import cc.ankin.deeplogtoolserver.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    User getUserByUsername(String username);
    User getUserById(String id);
    void insetUser(User user);
    void updateUser(User user);

}
