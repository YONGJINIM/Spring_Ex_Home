package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.User;

@Mapper
public interface UserMapper {

	// input : 4개의 파라미터 
	// output : X
	
	public void insertUser(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd,
			@Param("email") String email,
			@Param("introduce") String introduce
			); 
	
	// input X 쿼리문 혼자 알아서 하기때문
	// return : User (하나의 행만 가져오기 때문에 User 하나만 가져옴) 단건이면 없을 수 있다. 
	public User selectLatestUser();
	
	// input : name
	// output: boolean t : 중복 f:중복 X
	public boolean isDuplicatedName(String name);
	
	
}
