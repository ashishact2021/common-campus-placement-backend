package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Student extends BaseEntity {

	// basic detials

	// form 3

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(length = 20)
	private Long prn;

	@Column(name = "dob")
	private LocalDate dob;

	// academic details

	// form 4

	@Column(name = "marks_10th", length = 10)
	private double mark10th;
	@Column(name = "passing_year_10th")
	private LocalDate passingYear10th;

	@Column(name = "marks_12th", length = 10)
	private double mark12th;
	@Column(name = "passing_year_12th")
	private LocalDate passingYear12th;

	@Column(name = "marks_diploma", length = 10)
	private double markDiploma;
	@Column(name = "passing_year_diploma")
	private LocalDate passingYearDiploma;

	@Column(name = "marks_grad", length = 10)
	private double markGrad;
	@Column(name = "passing_year_grad")
	private LocalDate passingYearGrad;

	@Column(name = "marks_post_grad", length = 10)
	private double markPostGrad;
	@Column(name = "passing_year_post_grad")
	private LocalDate passingYearPostGrad;

	// contact details

	// form 5

	@Column(length = 50)
	private String email;
	@Column(name = "mob_no", length = 13)
	private long mobNo;
	@Column(name = "address", length = 200)
	private String address;
	@Column(name = "git_link", length = 100)
	private String gitLink;
	@Column(name = "linkedin_link", length = 100)
	private String linkedIn;

	// default const
	public Student() {
		System.out.println("Student.Student()");
	}

	// association

	// student and course and table
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	// student and credential
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "credential_id")
	private Credential credential;

	// student and placement
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "student_id")
	private List<PlacementDetails> placementDetails = new ArrayList<>();

	// student and project
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "student_id")
	private List<Project> projects = new ArrayList<>();

	// student and resume
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "resume_id")
	private StudentResume resume;

	// student and photo
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "photo_id")
	private StudentResume photo;

}
