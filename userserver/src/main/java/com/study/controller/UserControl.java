package com.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.pojo.User;
import com.study.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControl {

    @Autowired
    private UserServer userServer;

    @GetMapping("/user/{ids}")
    public List<User> selectUserByid(@PathVariable("ids")List<Integer> ids){
        List<User> users=new ArrayList<>();
        for (Integer id:ids) {
            User user = userServer.selertUserById(id);
            users.add(user);
        }
        ObjectMapper mapper=new ObjectMapper();

        StringWriter stringWriter=new StringWriter();


        List<User> ls=new ArrayList<>();
        try {
            mapper.writeValue(stringWriter,users);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
