package com.practice.dao;

import java.util.List;

import com.practice.entity.Course;

public interface CourseRepository {

	Course findById(Long id);
	Course save(Course course);
	void deleteById(Long id);
	
	List<Course> findall_Jpql();
	List<Course> findSpecific_Jpql();
	
	List<Course> nativeQueryBasic();
	List<Course> nativeQueryParameters();
	List<Course> nativeQueryNamedParameters();
	
	
	
	void playWithEntityManager();
}
