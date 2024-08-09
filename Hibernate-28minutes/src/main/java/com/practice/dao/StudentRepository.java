package com.practice.dao;


import com.practice.entity.Passport;
import com.practice.entity.Student;

public interface StudentRepository {
	
	void saveStudentWithPassport();
	Student retrieveStudentById(Long id);
	Passport retievePassportbyId(Long id);
	
	
}
