package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller // Spring bean으로 등록
@RequestMapping("/lesson01/ex01") // 공통 패스를 앞에 빼둘 수 있다.
public class Lesson01Ex01Controller {

	// http://localhost:8080/lesson01/ex01/1
	// String을 브라우저에 출력 
	@RequestMapping("/1")
	@ResponseBody
	public String ex01_1() {
		return "<h2>문자열을 ResponseBody에 보내는 예제</h2>"; 
	}
	
	// http://localhost:8080/lesson01/ex02/2
	// Map 리턴 => JSON String
	@RequestMapping("/2") 
	public @ResponseBody Map<String , Object> ex02_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("사과",3);
		map.put("망고",20);
		map.put("체리",51);
		map.put("포도",33);
		
		// map를 리턴하면 JSON String이 된다.
		// Web starter에 jackson 라이브러리 있기 때문이다.
		return map; // {"사과" = 30....}
	}
}
	
	
	

