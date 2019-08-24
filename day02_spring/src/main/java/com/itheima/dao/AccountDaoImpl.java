package com.itheima.dao;


import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAcoountDao{
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
