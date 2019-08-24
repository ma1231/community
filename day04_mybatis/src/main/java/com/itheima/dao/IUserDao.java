package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserDao {

    @Select(value="select * from user")
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday)values(#{username}.#{address},#{sex},#{birthday})")
    void saveUser(User user);

    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday} address=#{address} where id=#{id}")
    void updateUser(User user);
}
