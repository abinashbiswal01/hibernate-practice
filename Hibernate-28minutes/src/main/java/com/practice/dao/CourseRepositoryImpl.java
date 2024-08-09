package com.practice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.entity.Course;

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
	

}
