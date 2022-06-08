package cn.bdqn.dao;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from User")
    List<User> list();


    @Insert("insert into User(username,password) values (#{username},#{password})")
    void add(User user);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void update(User user);

    @Delete("delete from User where id=#{id}")
    void delete(int id);

    @Select("select * from User where id=#{id}")
    User getUserByid(int id);
}
