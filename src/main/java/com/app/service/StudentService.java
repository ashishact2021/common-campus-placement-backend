package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exception.CourseNotFoundException;
import com.app.dao.CourseRepository;
import com.app.dao.StudentRepository;
import com.app.pojos.Batch;
import com.app.pojos.Course;
import com.app.pojos.CourseName;
import com.app.pojos.Credential;
import com.app.pojos.PlacementDetails;
import com.app.pojos.Project;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentService implements IStudentService{
	 
	@Autowired
	private StudentRepository  studentRepo;
	
	@Autowired
	 private CourseRepository courseRepo;
	
	// student Registraton
	@Override
	public Student studentRegistration(int year,String batch, String courseName,Student student) {
	    Batch batch1=Batch.valueOf(batch.toUpperCase());
	    CourseName courseName1=CourseName.valueOf(courseName.toUpperCase());
	    Optional<Course> courseOptional = courseRepo.findByCourseNameAndBatchAndYear(courseName1, batch1, year);
	  Course course=  courseOptional.orElseThrow(()-> new CourseNotFoundException("can not the find the course !!"));
	  course.getStudents().add(student);
	   student.setCourse(course);
	   return student;
	}


	// store Credential
	@Override
	public int studentCredential(  Credential credential) {
		
		return 0;
	}

	// store project details
	@Override
	public int studentProject(Project project) {
		return 0;
	}

	// store placement details
	@Override
	public int studentPlacement(PlacementDetails placementDetails) {
		return 0;
	}

	// store student resume
	@Override
	public int studentResume(MultipartFile studentResume) {
		// create resume class instance and set the property by fetching multipart file
		// and then store the resume instance
		// in the database
		return 0;
	}

	// store student photo
	@Override
	public int studentPhoto(MultipartFile studentPhoto) {
		// create Photo class instance and set the property by fetching multipart file
		// and then store the Photo instance
		// in the database
		return 0;
	}
}
