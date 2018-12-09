package com.study.controller;

import com.study.dao.ConsumerClient;
import com.study.dao.ConsumerDao;
import com.study.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControl {

    @Autowired
    private ConsumerDao consumerDao;

    @Autowired
    private ConsumerClient consumerClient;

    @GetMapping("/consumer/{ids}")
    public List<User> selectUserByServer(@PathVariable("ids") Integer[] ids){

//        List<User> users = consumerDao.selectByConsumer(ids);

        List<User> users_client = consumerClient.selectUserByid(ids);


        return users_client;
    }
}
