package com.itheima.service.impl;

import com.itheima.dao.IPermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.IPermissioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissioService {

    @Autowired
    IPermissionDao iPermissionDao;

    public List<Permission> findAll() {
        return iPermissionDao.findAll();
    }

    public void save(Permission permission) {
        iPermissionDao.save(permission);
    }
}
