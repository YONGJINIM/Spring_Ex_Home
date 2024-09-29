package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper
public interface UsedGoodsMapper {
	
	// input = BO한테 받아온다 하지만 데이터는 없음 
	// output = BO한테 List<UsedGoods> 넘겨줌 
	public List<UsedGoods> selectUsedGoodsList();
	
}
