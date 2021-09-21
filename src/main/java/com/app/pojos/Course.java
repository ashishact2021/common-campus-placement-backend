package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class Course extends BaseEntity {
   
	
	// form 2
	
	
	@Column(name = "course_name", length = 20)
	private String courseName;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Batch batch;

	@Column(name = "course_year", length = 4)
	private int year;

	public Course(String courseName, Batch batch, int year) {
		super();
		this.courseName = courseName;
		this.batch = batch;
		this.year = year;
	}

	// association
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Student> students = new ArrayList<>();

	// default const
	public Course() {
		System.out.println("Course.Course()");
	}

	// toString
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", batch=" + batch + ", year=" + year + ", getId()=" + getId()
				+ "]";
	}

}
