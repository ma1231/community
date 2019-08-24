package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IOrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrdersDao iOrdersDao;

    public List<Orders> findAll(int page,int size) throws Exception {
        //page页码值，size页码数
        PageHelper.startPage(page,size);
        return iOrdersDao.findAll(page,size);
    }

    public Orders findById(Integer id) throws Exception {
       return iOrdersDao.findById(id);
    }
}
