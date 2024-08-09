package com.practice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	private String rating;
	private String description;
	
	public Review() {
		
	}

	public Review(String description,String rating) {
		this.description = description;
		this.rating=rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", description=" + description + "]";
	}
	
	
	
	
	
}
