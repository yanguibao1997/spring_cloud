package com.study.server;

import com.study.mapper.UserMapper;
import com.study.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServer {

    @Autowired
    private UserMapper userMapper;

    public User selertUserById(Integer id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
