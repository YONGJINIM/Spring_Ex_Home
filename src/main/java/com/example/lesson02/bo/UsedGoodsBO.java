package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

//Service 레이어: 비즈니스 로직을 처리하는 클래스 (Business logic layer)
//BO(Business Object)로 역할을 수행하는 클래스
@Service // Spring Bean으로 등록하여, 스프링에서 관리되도록 함
public class UsedGoodsBO {
 
	 @Autowired // 의존성 주입(DI, Dependency Injection) - UsedGoodsMapper 객체를 자동으로 주입받음
	 private UsedGoodsMapper usedGoodsMapper;
	 
	 // input: 컨트롤러로부터 받은 요청 (특정 인풋은 없음)
	 // output: 컨트롤러에게 List<UsedGoods> 형태의 데이터를 반환
	 
	 // getUsedGoodsList() 메서드: UsedGoods 데이터를 List 형태로 반환
	 public List<UsedGoods> getUsedGoodsList() {
	     List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList(); // DB에서 상품 목록을 가져옴
	     return usedGoodsList; // 컨트롤러(Lesson02Ex01RestController)로 반환
	 	}
}
