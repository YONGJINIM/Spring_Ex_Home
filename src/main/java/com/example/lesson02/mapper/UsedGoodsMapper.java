package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper // MyBatis Mapper로서 SQL 쿼리와 연결되는 인터페이스임을 명시
public interface UsedGoodsMapper {

    // input: BO(UsedGoodsBO)로부터 요청을 받음 (특정 입력은 없음)
    // output: List<UsedGoods> 형태로 상품 목록을 BO에 반환

    // 중고 상품 목록을 조회하는 메서드 - 데이터베이스에서 가져옴
    public List<UsedGoods> selectUsedGoodsList();

}
