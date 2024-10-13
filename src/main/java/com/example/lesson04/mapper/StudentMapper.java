package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Student;

@Mapper
public interface StudentMapper {

	
	// input: Student 
	// output: int ot void 
	
	public void insertStudent(Student student); // 하나의 객체로 받아오기 때문에 @Param 필요없음
	
	// input:  id(int) id로 조회하기 때문에 
	// output: Student student id에 해당하는 하나
	
	public Student selectStudentById(int id);
}
