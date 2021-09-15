package com.wenkai.nowcode_community.service;

import com.wenkai.nowcode_community.dao.UserMapper;
import com.wenkai.nowcode_community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
