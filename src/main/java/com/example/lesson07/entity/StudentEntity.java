package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // toString() 메서드를 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자를 자동 생성
@NoArgsConstructor // 기본 생성자를 자동 생성
@Builder(toBuilder = true) // setter 대신, toBuilder = true 필드의 수정을 허용
@Getter // 모든 필드의 Getter 메서드를 자동 생성
@Entity // 이 클래스가 JPA 엔티티임을 나타냄. DB 테이블과 매핑됨
@Table(name = "new_student") // DB 테이블 이름을 "new_student"로 매핑

public class StudentEntity { // JPA는 => StudentEntity를 테이블 명으로 기억함. 
	@Id // PK 식별자
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert시 방금 들어간 id를 가져온다.
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber") // 카멜케이스로 되어있는 것은 무조건 사용
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@CreationTimestamp	// 값이 null이여도 insert 되는 시간으로 자동으로 채워준다.
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp	// insert/update 그 시간으로 
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}
