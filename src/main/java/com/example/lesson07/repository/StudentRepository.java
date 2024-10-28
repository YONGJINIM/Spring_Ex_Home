package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	// 순수한 JPA vs Spring Data JPA
	// public StudentEntity save(StudentEntity studentEntity); <= 이런 의미가 숨겨져있다.
	// public Optional<StudentEntity> StudentEntity findById(int id); findById가 내장되어 있다. 
	// public void delete(StudentEntity studentEntity);
	
	// 조회
	// public List<StudentEntity> finadAll();
	
	// ex02/select1 => JPQL 메소드 규칙 => JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String keyword);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	// ex02/select2 => JPQL(쿼리문처럼 생겼지만 엔티티에 조회) - SQL 쿼리문
//	@Query(value = "select s from StudentEntity s where s.dreamJob = :dreamJob")
//	public List<StudentEntity> findByDreanJob(@Param("dreamJob") String dreamJob);
	
	// ex02/select2 => SQL Query - native query 
	@Query(value = "select * from new_student where DreamJob = :dreamJob" ,nativeQuery = true)
	public List<StudentEntity> findByDreanJob(@Param("dreamJob") String dreamJob);
	
	
	
	
}
