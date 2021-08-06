package com.xdu.demomptest;

import com.xdu.demomptest.entity.User;
import com.xdu.demomptest.mapper.UserMapper;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootApplication
@MapperScan("com.xdu.demomptest.mapper")
public class DemomptestApplication {
	@Autowired
	private UserMapper userMapper;





}
