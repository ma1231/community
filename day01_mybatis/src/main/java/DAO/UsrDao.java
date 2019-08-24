package DAO;

import cn.itcast.domain.User;
import cn.itcast.mybatis.annotations.Select;

import java.util.List;

public interface UsrDao {

    @Select("select * from user")
    List<User> findall();
}
