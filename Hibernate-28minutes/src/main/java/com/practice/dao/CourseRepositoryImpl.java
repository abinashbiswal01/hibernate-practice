package com.practice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.entity.Course;
import com.practice.entity.Review;

import ch.qos.logback.classic.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {

	@Autowired
	EntityManager em;
	
	@Override
	public Course findById(Long id) {
		
		return em.find(Course.class, id);
	}

	@Override
	public Course save(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		Course course=findById(102L);
		em.remove(course);
		
	}

	@Override
	public void playWithEntityManager() {
		Course course1= new Course("Spring Boot 5.3");
		em.persist(course1);
		
		Course course2= new Course("RestFul Services-2");
		em.persist(course2);
		
		em.flush();
		
		//em.detach(course2);
		//em.clear();
		
		course1.setName("Spring Boot 5.5 -updated");
		course2.setName("Restful Services-2-updated");
		em.refresh(course1);
	}
	
	@Override
	public List<Course> findall_Jpql() {
		//TypedQuery<Course> query=em.createQuery("select c from Course c", Course.class);
		TypedQuery<Course> query=em.createNamedQuery("query_get_all_courses", Course.class);
		return query.getResultList();
	}
	
	@Override
	public List<Course> findSpecific_Jpql() {
		//TypedQuery<Course> query=em.createQuery("select c from Course c where name like '%-updated%'", Course.class);
		TypedQuery<Course> query=em.createNamedQuery("query_get_all_updated", Course.class);
		return query.getResultList();
	}
	
	@Override
	public List<Course> nativeQueryBasic() {
		Query query=em.createNativeQuery("SELECT * FROM COURSE", Course.class);
		return query.getResultList();
	}
	
	public List<Course> nativeQueryParameters() {
		Query query=em.createNativeQuery("SELECT * FROM COURSE where id=?", Course.class);
		query.setParameter(1, 103L);
		return query.getResultList();
	}
	
	public List<Course> nativeQueryNamedParameters() {
		Query query=em.createNativeQuery("SELECT * FROM COURSE where id=:id", Course.class);
		query.setParameter("id", 202L);
		return query.getResultList();
	}

	@Override
	@Transactional
	/*public void addReviewsForCourse(Long id) {
		//get the course
		Course course= em.find(Course.class, id);
		System.out.println(course.getReviews());
		Review review1= new Review("Not good","2");
		Review review2= new Review("Poor English,cannot understand","1");
		
		
		//SETTING THE RELATIONSHIP
		//add two reviews in the course 
		//and add the course detail in each review object
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		//save it to the DB
		em.persist(review1);
		em.persist(review2);
		
	}*/
	
	public void addReviewsForCourse(Long id,List<Review> reviews) {
		//get the course
		Course course= em.find(Course.class, id);
		System.out.println(course.getReviews());
		
		for(Review review:reviews) {
			
			//setting the relationship
			course.addReview(review);
			review.setCourse(course);
		
			em.persist(review);
		}
	}
	
	
	

}
