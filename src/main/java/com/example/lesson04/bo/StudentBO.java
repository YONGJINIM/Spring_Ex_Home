package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA
	public StudentEntity addStudent(
			String name,
			String phoneName,
			String email,
			String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneName)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// mybitis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student selectStudentById(int id) {
		return studentMapper.selectStudentById(id); // mapper 에게 id를 줄테니 student의 한개의 데이터를 가져와줘 그걸 controller로 전달
	}
	
	public StudentEntity updateStudentDreamJobById(int id , String dreamJob) {
		// 기존 데이터 조회 - id entity 
		StudentEntity student = studentRepository.findById(id).orElse(null);
	
		// update - save() - insert, update(pk가 있을 때)
		if(student != null) {
			// 조회된 데이터가 존재할 때만 업데이트를 진행
			
			// 변경할 내용을 엔티티에 세팅 후 save(id가 있어서) update 
			student = student.toBuilder()
			.dreamJob(dreamJob)
			.build();
			
			student = studentRepository.save(student);
		} 
		
		return student;
	}
	public void deleteStudentById(int id) {
		// 방법1) 삭제할 대상을 select 후 삭제 
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if(student != null) {
//			studentRepository.delete(student);
//		}
		// 방법2) 삭제할 대상을 select 후 삭제
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	
	}
}
