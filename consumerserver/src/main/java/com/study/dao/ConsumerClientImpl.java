package com.study.dao;

import com.study.pojo.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsumerClientImpl implements ConsumerClient {


    @Override
    public List<User> selectUserByid(Integer[] ids) {
        List<User> users=new ArrayList<>();
        User user=new User();
        user.setName("Hystrix进行了熔断了");
        users.add(user);
        return users;
    }
}
