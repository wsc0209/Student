package cn.bdqn.service;



import cn.bdqn.pojo.User;

import java.util.List;

public interface UserService {


    List<User> list();

    void add(User user);

    void update(User user);

    void delete(int id);

    User getUserByid(int id);
}
