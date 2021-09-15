package com.wenkai.nowcode_community.dao;

import com.wenkai.nowcode_community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //用于查询用户个人以发过的帖子, offset 每一页起始行的行号， limit每一页最多显示的行数

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param 注解用于给参数取别名
    //如果只有一个参数，并且在<IF>里使用，则必须加别名
    //返回数据总行数
    int selectDiscussPostRows(@Param("userId") int userId);


}
