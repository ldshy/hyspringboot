package com.example.Service.Impl;

import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbctemplate;

    public void createJdbcUser(){
        jdbctemplate.update("INSERT INTO hy_spring(username,userage) VALUE(?,?);","黄宇",24);
    }

}
