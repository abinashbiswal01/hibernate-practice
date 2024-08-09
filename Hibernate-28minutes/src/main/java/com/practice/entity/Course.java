package com.practice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
}
