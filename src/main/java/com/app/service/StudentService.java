package com.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Course;
import com.app.pojos.Credential;
import com.app.pojos.PlacementDetails;
import com.app.pojos.Project;
import com.app.pojos.Student;

public class StudentService implements IStudentService{
	
	// student Registraton
	@Override
	public int studentRegistration(Student student) {
		return 0;
	}

	// course updation
	@Override
	public int studentCourse(Course course) {
		return 0;
	}

	// store Credential
	@Override
	public int studentCredential(Credential credential) {
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
