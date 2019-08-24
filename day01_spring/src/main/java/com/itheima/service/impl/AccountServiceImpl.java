package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

//账户业务层实现类
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();
    //private IAccountDao accountDao= (IAccountDao) BeanFactory.getBean("accountDao");


    @Override
    public void saveAccount() {
        int i=1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
