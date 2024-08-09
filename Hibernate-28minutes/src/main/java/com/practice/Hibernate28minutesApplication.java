package com.practice;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.dao.CourseRepository;
import com.practice.dao.StudentRepository;
import com.practice.entity.Course;
import com.practice.entity.Passport;
import com.practice.entity.Review;
import com.practice.entity.Student;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Hibernate28minutesApplication implements CommandLineRunner {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Hibernate28minutesApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		logger.info(null);
		//courseRepository.addReviewsForCourse(1001L);
		List<Review> list= new ArrayList<>();
		Review review1= new Review("Good, but outdated","3");
		Review review2= new Review("no latest information","2");
		list.add(review1);
		list.add(review2);
		courseRepository.addReviewsForCourse(1002L, list);
	}
	
	private void dontCall() {
//		repository.findById(1L);
//		logger.info(null);
		//courseRepository.playWithEntityManager();
		//courseRepository.deleteById(102l);
		/*
		 * List<Course> courses= courseRepository.findall_Jpql();
		 * logger.info("AlL courses fetched : "+courses); List<Course> updatedCourses=
		 * courseRepository.findSpecific_Jpql();
		 * logger.info("updated courses fetched: "+updatedCourses);
		 */
		
		/*
		 * List<Course> nativeCourses=courseRepository.nativeQueryBasic();
		 * logger.info("Native Querybasic - result::"+nativeCourses);
		 * 
		 * List<Course> nativeCourses1=courseRepository.nativeQueryNamedParameters();
		 * logger.info("Native Querybasic - result::"+nativeCourses1.get(0));
		 */
		
		//studentRepository.saveStudentWithPassport();
//		Student s=studentRepository.retrieveStudentById(2001l);
//		logger.info("Retrieved Student wwith id=2001 is : "+s);
//		logger.info("His passport details are: "+s.getPassport());
		
//		Passport p=studentRepository.retievePassportbyId(4001L);
//		logger.info("Retrieved Passpor with id=2001 is : "+p);
//		logger.info("Associated Student details are: "+p.getStudent());
		
	}

}
