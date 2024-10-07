package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input: int
	// output: Review 단건 or 없으면 null
	public Review selectReviewById(int id); 
	
	// input : Review(도메인 객체를 사용) 
	// output : Void or int(수행된 행의 개수) => Mybatis가 성공된 행의 개수를 준다.
	public int insertReview(Review review); 
	
	// input : Review
	// output : int(수행된 행의 개수) 사용 => mybatis가 성공된 행의 개수를 준다.
	public int insertReviewAsField(
			@Param("storeId") int storeId,
			@Param("menu") String menu,
			@Param("userName") String userName,
			@Param("point") Double point,
			@Param("review") String review);
	
	// input : id, review 
	// output : int(성공한 행의 개수)
	
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review
			);
	// input : id
	// output : int 
	public int deleteReviewById(int id);
}
