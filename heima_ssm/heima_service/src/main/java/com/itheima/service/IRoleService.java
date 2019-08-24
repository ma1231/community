package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    void save(Role role);

    Role findRoleById(Integer roleId);

    List<Permission> findOtherPermissions(Integer roleId);

    void addPermissionToRole(Integer roleId, Integer[] permissionIds);
}
