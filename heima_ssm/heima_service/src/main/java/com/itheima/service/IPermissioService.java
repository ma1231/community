package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface IPermissioService {

    List<Permission> findAll();

    void save(Permission permission);
}
