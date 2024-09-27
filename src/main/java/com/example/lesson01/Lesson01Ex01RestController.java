package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + ResponseBody
@RequestMapping("/lesson01/ex01/")
public class Lesson01Ex01RestController {

	
	// http://localhost:8080/lesson01/ex01/3 
	@RequestMapping("/3")
	public String ex01_3() {
		return "<h3>@RestController 사용해서 String 리턴</h3>";
	}
	
	// http://localhost:8080/lesson01/ex01/4 
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("AAA", "BBB");
		map.put("CCC", "DDD");
		map.put("EEE", "FFF");
		map.put("GGG", "HHH");
		
		return map;
	}
	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
	Data data = new Data();
	data.setId(1);
	data.setName("임용진");
	
	return data;
	}
	// http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(1);
		data.setName("바다");
		
		// return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR); 500번 
		return new ResponseEntity<>(data,HttpStatus.CREATED); // 201번
	}
	
	
	
	
}
