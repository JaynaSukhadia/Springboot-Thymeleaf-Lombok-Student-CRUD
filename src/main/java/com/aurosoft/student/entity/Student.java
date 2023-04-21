package com.aurosoft.student.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data


@Entity
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private int id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="city",nullable = false)
	private String city;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "age", nullable = false)
	private int age;
	
}
