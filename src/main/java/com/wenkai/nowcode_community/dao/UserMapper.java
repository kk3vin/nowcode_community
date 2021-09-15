package com.wenkai.nowcode_community.dao;

import com.wenkai.nowcode_community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    //return the number of inserted rows
    int insertUser(User user);
    //return the number of updated rows
    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);



}
