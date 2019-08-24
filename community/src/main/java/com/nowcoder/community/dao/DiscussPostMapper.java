package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);//userId在个人主页使用

    //查询出所有行数，方便分页
    //@Param给参数去别名，只有一个参数并且在<if>里使用必须用 动态sql
    int selectDiscussPostRows(@Param("userId") int userId);
}
