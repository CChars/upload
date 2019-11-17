package com.poi.testpoi.mapper;

import com.poi.testpoi.pojo.Mate;
import com.poi.testpoi.pojo.User;

import java.util.List;

public interface UserMapper {


	List<User> selectUsers();
	//monday
	List<User> selectMon_MoonByDays(int mon_moon);
	List<User> selectMon_NightByDays(int mon_night);
	//TUE
	List<User> selectTue_MoonByDays(int tue_moon);
	List<User> selectTue_NightByDays(int tue_night);
	//WEN
	List<User> selectWen_MoonByDays(int wed_moon);
	List<User> selectWen_NightByDays(int wed_night);
	//THU
	List<User> selectThu_NightByDays(int thu_moon);
	//FRI
	List<User> selectFri_MoonByDays(int fri_moon);
	List<User> selectFri_NightByDays(int fri_night);
	//SAT
	List<User> selectSat_MoonByDays(int sat_moon);
	List<User> selectSat_NightByDays(int sat_night);
	//SUN
	List<User> selectSun_MoonByDays(int sun_moon);
	List<User> selectSun_NightByDays(int sun_night);

	List<User> selectByBook(int book);

	void updateUserByName(User user);

	void addUser(User user);

	void deleteAllDate();

	int selectByName(String username);


}
