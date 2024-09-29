package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController
public class Lesson02Ex01RestController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	// http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	
	public List<UsedGoods> ex01(){ // List에 `UsedGoods`를 담을 것이다.
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList(); //__DB에서가져옴__;
		
		return usedGoodsList; // JSON String 
	}
}
