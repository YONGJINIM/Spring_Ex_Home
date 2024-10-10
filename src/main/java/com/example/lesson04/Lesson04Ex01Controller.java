package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@Controller // HTML 경로일 때는 @ResponseBody가 없다 
@RequestMapping("/lesson04/ex01") // 공통 경로 
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면 
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view" , method = RequestMethod.GET) //주소로 들어오기 때문에 GET방식
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
	// 최신 가입자 정보 화면
	// http://localhost/lesson04/ex01/latest-user-view
	// 주소를 치고 들어오면 바로 보이기 때문에 GET Mapping
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) {
		
		// DB select (브레이크 포인트 걸어서 User를 잘 가져왔는지 확인)
		User user = userBO.getLatestUser();
		
		// 컨트롤러가 Model이란 상자에 데이터(User)를 집어넣는다. 
		// HTML(View)가 Model에서 꺼내서 쓴다.
		
		// key value로 넣음 
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입된 유저");
		
		
		return "lesson04/latestUser"; // view의 경로 
	}
	
	
}
