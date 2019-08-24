package com.itheima.service.impl;

import com.itheima.dao.ISysLogDao;
import com.itheima.domain.SysLog;
import com.itheima.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    ISysLogDao iSysLogDao;

    public void save(SysLog sysLog) {
        iSysLogDao.save(sysLog);
    }

    public List<SysLog> findAll() {
        return iSysLogDao.finAll();
    }
}
