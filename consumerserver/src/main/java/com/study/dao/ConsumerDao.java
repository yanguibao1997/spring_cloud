package com.study.dao;

import com.study.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ConsumerDao {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<User> selectByConsumer(List<Integer> ids){
        List<ServiceInstance> instances = discoveryClient.getInstances("user-server");
        ServiceInstance serviceInstance = instances.get(0);
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("http://").append(serviceInstance.getHost()).append(":").append(serviceInstance.getPort()).append("/user/");
        String s="";
        for (Integer id:ids) {
            s+=id+",";
        }
        stringBuffer.append(s.substring(0,s.length()-1));

        List<User> users = restTemplate.exchange(stringBuffer.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {}).getBody();


        return users;
    }
}
