package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RestController
@RequestMapping("/lesson07/ex01")
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// C : Create 
	@GetMapping("create")
	public StudentEntity create() {
		String name = "잉용징"; // bo로 넘길 것 
		String phoneNumber = "010-1234-5678"; // bo로 넘길 것 
		String email = "dk67@naver.com"; // bo로 넘길 것 
		String dreamJob = "개발자"; // bo로 넘길 것
		
		// save 된 객체를 리턴하므로 id를 채워진 상태로 리턴
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U :update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 5인 dreamJob의 값을 변경 개발자 -> 선생님
		return studentBO.updateStudentDreamJobById(5, "선생님");
	}
	// D: delete 
	@GetMapping("/delete")
	public String delete() {
		// id 5번을 삭제 
		studentBO.deleteStudentById(4);
		return "삭제완료";
	}
}
