package com.itheima.service.impl;

import com.itheima.dao.IAcoountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 */

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "accountDao")
    private IAcoountDao acoountDao;


    public void  saveAccount(){
       acoountDao.saveAccount();
    }



}
