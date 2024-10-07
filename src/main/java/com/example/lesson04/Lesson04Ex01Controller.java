package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@Controller // HTML 경로일 때는 @ResponseBody가 없다 
@RequestMapping("/lesson04/ex01") // 공통 경로 
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면 
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view" , method = RequestMethod.GET)
	// String을 return 하면 @ResponseBody가 없어 경로로 인식함 
	public String addUserView() {
		return "lesson04/addUser"; //HTML 경로 
	}
	// 회원가입 데이터 DB에 insert => 결과 화면으로 이동 
	@PostMapping("/add-user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			// DB상 introduce는 Null값을 허용함 required 사용 
			@RequestParam(value = "introduce" , required = false) String introduce) {
	
			// DB insert
			userBO.addUser(name, yyyymmdd, email, introduce);
		
			// 결과 화면 이동 
			return "lesson04/afterAddUser";	
	}
	
}
