package com.poi.testpoi;

import com.poi.testpoi.mapper.UserMapper;
import com.poi.testpoi.pojo.User;
import com.poi.testpoi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(value = {"com.poi.testpoi.mapper"})
public class TestpoiApplicationTests {


	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		List<User> users = userMapper.selectUsers();
		System.out.println("_________________>" + users);
	}

	@Test
	public void contextLoad_() {
		List<User> users = userService.selectUsers();
		System.out.println("_________________>" + users);
	}


	@Test
	public void ecule() throws Exception {

	}



}
