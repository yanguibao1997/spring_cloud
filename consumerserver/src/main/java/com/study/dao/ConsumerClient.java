package com.study.dao;

import com.study.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "user-server", fallback = ConsumerClientImpl.class)
public interface ConsumerClient {

    @GetMapping("/user/{ids}")
    List<User> selectUserByid(@PathVariable("ids") Integer[] ids);
//    List<User> selectUserByid(@PathVariable("ids") List<Integer> ids);
}
