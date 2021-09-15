package com.wenkai.nowcode_community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaoMybatisImpl implements AlphaDao {

    @Override
    public String select() {
        return "Mybatis";
    }
}
