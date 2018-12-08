package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(value = "com.study.mapper")
@EnableEurekaClient
public class UserserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserverApplication.class,args);
	}
}
