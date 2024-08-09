package com.practice.dao;

import java.util.List;

import com.practice.entity.Course;
import com.practice.entity.Review;

public interface CourseRepository {

	Course findById(Long id);
	Course save(Course course);
	void deleteById(Long id);
	
	List<Course> findall_Jpql();
	List<Course> findSpecific_Jpql();
	
	List<Course> nativeQueryBasic();
	List<Course> nativeQueryParameters();
	List<Course> nativeQueryNamedParameters();
	
	void addReviewsForCourse(Long id,List<Review> reviews);
	
	
	
	void playWithEntityManager();
}
