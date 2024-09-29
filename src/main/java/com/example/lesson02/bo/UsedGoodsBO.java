package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

// Service (Bussoness logic) => BO(Bussiness Object)
// 패키지는 bo => UsedGoodsBO
@Service // Spring Bean으로 등록
public class UsedGoodsBO {
	
	@Autowired // DI(Dependency Injecton): 의존성 주입
	private UsedGoodsMapper usedGoodsMapper;
	
	// input: 아무것도 없음 컨트롤러한테 받는다.  
	// output 컨트롤러한테 ListUsedGoods를 준다. 
	
	// 컨트롤러한테 받은 아웃풋 => List<UsedGoods>
	// getUsedGoodsList() <= 컨트롤러한테 받는 인풋 
	
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList();
		return usedGoodsList; // Lesson02Ex01RestController로 리턴
	}
	

}
