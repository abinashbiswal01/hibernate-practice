package com.practice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@NamedQueries(value = {
		@NamedQuery(name="query_get_all_courses",
				query="select c from Course c"),
		@NamedQuery(name="query_get_all_updated",
		query="select c from Course c where name like '%-updated%'")
})
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "course")// by default fetch type is lazy for OneToMany side
	private List<Review> reviews=new ArrayList<>();
	
	public Course() {
		
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	// we don't want to set reviews manually by passing the List
	/*
	 * public void setReviews(List<Review> reviews) { this.reviews = reviews; }
	 */
	
	//so, we modify the method
	public void addReview(Review review) { 
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) { 
		this.reviews.remove(review);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
}
