package com.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Course;
import com.app.pojos.Credential;
import com.app.pojos.PlacementDetails;
import com.app.pojos.Project;
import com.app.pojos.Student;

public interface IStudentService {

		int studentRegistration(Student student);

		int studentCourse(Course course);

		int studentCredential(Credential credential);

		int studentPlacement(PlacementDetails placementDetails);

		int studentResume(MultipartFile studentResume);

		int studentPhoto(MultipartFile studentPhoto);

		int studentProject(Project project);
	
}
