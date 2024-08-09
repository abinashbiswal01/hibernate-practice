package com.practice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.entity.Passport;
import com.practice.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	EntityManager em;
	
	@Override
	public void saveStudentWithPassport() {
		Passport passort=new Passport("B34567");
		em.persist(passort);
		
		Student student =new Student("Bumrah");
		student.setPassport(passort);
		em.persist(student);
		
	}
	
	@Override
	public Student retrieveStudentById(Long id) {
		//eager loading of passport details on asking for student
		return em.find(Student.class, id);
	}
	
	@Override
	public Passport retievePassportbyId(Long id) {
		return em.find(Passport.class, id);
	}

}
