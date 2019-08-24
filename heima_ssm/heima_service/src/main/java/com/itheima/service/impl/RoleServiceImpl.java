package com.itheima.service.impl;

import com.itheima.dao.IRoleDao;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao iRoleDao;

    public List<Role> findAll() {
        return iRoleDao.findAll();
    }

    public void save(Role role) {
        iRoleDao.save(role);
    }

    public Role findRoleById(Integer roleId) {
       return iRoleDao.findRoleById(roleId);
    }

    public List<Permission> findOtherPermissions(Integer roleId) {
        return iRoleDao.findOtherPermissions(roleId);
    }

    public void addPermissionToRole(Integer roleId, Integer[] permissionIds) {
        for (Integer permissionId : permissionIds) {
            iRoleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
