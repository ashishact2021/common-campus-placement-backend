package com.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Credential;
import com.app.pojos.PlacementDetails;
import com.app.pojos.Project;
import com.app.pojos.Student;

public interface IStudentService {

	Student studentRegistration(int year, String batch, String courseName, Student student);

	int studentCredential(Credential credential);

	int studentPlacement(PlacementDetails placementDetails);

	int studentResume(MultipartFile studentResume);

	int studentPhoto(MultipartFile studentPhoto);

	int studentProject(Project project);

}
