package com.poi.testpoi.service;

import com.poi.testpoi.pojo.Day;
import com.poi.testpoi.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

	List<User> selectUsers();
	/* *
	 * @Author QianZ
	 * @Description //选出每一个时间段的有空的学生作为一个list
	 * @Date 17:50 2019/10/27
	 * @Param []
	 * @return java.util.List<java.lang.String>
	 **/
	List<Day> selectDaysUsers();

	boolean batchImport(String fileName, MultipartFile file) throws Exception;
}
