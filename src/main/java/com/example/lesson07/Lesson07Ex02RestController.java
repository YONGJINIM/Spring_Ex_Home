package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RestController
@RequestMapping("/lesson07/ex02")
public class Lesson07Ex02RestController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/select")
	public List<StudentEntity> select1(){
		// 1) 모든 행을 전부 조회 
		// return studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회 
		// return studentRepository.findAllByOrderByIdDesc();
	
		// 3) id 기준 내림차순 3개 행 조회 
		// return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 "임용진"인 데이터를 조회 
		// return studentRepository.findByName("임용진");
		
		// 5) in문으로 일치하는 이름의 값 전부 조회 
		// 임용진 유재석 => 리스트 형태로 파라미터를 보내야함.
		//return studentRepository.findByNameIn(List.of("유재석","임용진"));
	
		// 6) 여러 컬럼값과 일치하는 데이터를 조회
		// 이름: 임용진, 장래희망: 개발자
		//return studentRepository.findByNameAndDreamJob("임용진", "개발자");
	
		// 7) email에 naver가 포함이 된 데이터가 존재하는지 조회 - like문 %naver%
		// return studentRepository.findByEmailContains("naver");
		
		// 8) 이름이 "임"으로 시작하는 데이터를 조회한다. - like문 임%
		// return studentRepository.findByNameStartingWith("임");
		
		// 9) id 1 ~ 3 조회 		between id 1 and 3
		return studentRepository.findByIdBetween(1,3);
	}
	
		@GetMapping("/select2")
		public List<StudentEntity> select2(){
			// 장래희망이 '변호사' 조회 
			return studentRepository.findByDreanJob("변호사");
		}
}
