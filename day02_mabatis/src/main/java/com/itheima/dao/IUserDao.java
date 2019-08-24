package com.itheima.dao;

import com.itheima.domain.QureyVo;
import com.itheima.domain.User;

import java.util.List;

//用户持久层接口
public interface IUserDao {

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);
    void deleteUser(Integer id);

    //模糊查询
    List<User> findName(String username);


    List<User> findUserByCondition(User user);

    List<User> findUserInIds(QureyVo vo);
}
