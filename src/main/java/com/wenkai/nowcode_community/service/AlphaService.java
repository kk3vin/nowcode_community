package com.wenkai.nowcode_community.service;

import com.wenkai.nowcode_community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public AlphaService(){
        System.out.println("Contruct");
    }

    @PostConstruct
    public String getData(){
        return alphaDao.select();
    }

    @PreDestroy
    public void destory(){
        System.out.println("Destory AlphaService");
    }

}
