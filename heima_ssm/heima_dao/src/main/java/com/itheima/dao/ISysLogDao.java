package com.itheima.dao;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {

    @Insert("insert into sysLog values(#{id},#{visitTime},#{username},#{url},#{ip},#{executionTime},#{method})")
    void save(SysLog sysLog);

    @Select("select * from sysLog")
    List<SysLog> finAll();
}
