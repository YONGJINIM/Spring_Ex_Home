package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student selectStudentById(int id) {
		return studentMapper.selectStudentById(id); // mapper 에게 id를 줄테니 student의 한개의 데이터를 가져와줘 그걸 controller로 전달
	}
}
