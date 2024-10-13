package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {

	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// http://localhost/lesson04/ex02/add-student-view
	
	@GetMapping("/add-student-view")
	public String addStudentView() {	
		return "/lesson04/addStudent";	// View의 경로 	
	}
	
	// 학생 DB 추가 => 방금 가입한 학생 화면 
	@PostMapping("/add-student")
	public String addStudent(@ModelAttribute Student student, // form 태그의 name과 field가 일치하면 세팅됨
			Model model) { // @ModelAttribute 나는 객체로 받아 올거다.
		
		// DB INSERT
		studentBO.addStudent(student);
		
		// DB SELECT 
		Student latestSudent = studentBO.selectStudentById(student.getId());
		
		// Model에 최근 학생의 정보를 담아서 뿌린다.
		model.addAttribute("student" , latestSudent);
		
		return "/lesson04/afterAddStudent"; // View 경로 (브레이크 포인트 걸어서 확인) 
	}
	
	
}