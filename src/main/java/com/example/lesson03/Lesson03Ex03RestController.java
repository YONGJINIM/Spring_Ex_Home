package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex03RestController {

	@Autowired
	private	ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex03?id=23&review=도미노피자는 맛있다.
	@RequestMapping("/lesson03/ex03")
	public String ex03_1 () {
		
		int rowCount = reviewBO.updateReviewById(
				23, 
				"도미노 피자는 맛있다.");
		
		return "변경완료" + rowCount;
	}
}
