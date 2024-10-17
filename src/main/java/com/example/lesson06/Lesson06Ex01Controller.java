package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller // 화면으로 가니까 컨트롤러 
@RequestMapping("/lesson06/ex01") // 공통 패스 미리 빼두기
public class Lesson06Ex01Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면 
	// http://localhost/lesson06/ex01/add-user-view
	@GetMapping("/add-user-view")
	public String addUserView() { 
		return "lesson06/addUser1";
	}
	
	
	// 회원가입 진행 => AJAX 요청 (익숙해질때까지 주석으로 적고 시작하자) 
	// AJAX 를 사용한 응답은 항상 String으로 주기 때문에 @RequestBody
	
	// DB Insert 
	// 리턴하는 글자만 바디에 담아서 리턴 
	@ResponseBody
	@PostMapping("/add-user")
	public String addUser(
		@RequestParam("name") String name, 
		@RequestParam("yyyymmdd") String yyyymmdd,
		@RequestParam("email") String email,
		@RequestParam(value = "introduce",required = false) String introduce) {
		
		// DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 응답 값 => String 
		// 브레이크 포인트를 걸어서 값이 잘들어오는지 확인해준다.
		return "성공";
		
		
	}
	
	// 가입완료 화면
	// http://localhost/lesson06/ex01/after-add-user-view
	@GetMapping("/after-add-user-view")
	public String afterAddUserView() {
		return "lesson06/afterAddUser1";
	}
	
	
}
