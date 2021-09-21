package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Course;
import com.app.pojos.Credential;
import com.app.pojos.PlacementDetails;
import com.app.pojos.Project;
import com.app.pojos.Student;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	// default const
	public StudentController() {
		System.out.println("StudentController.StudentController()");
	}

	/*-----------------------------------------------------------------------------------------------------------------------------------
	 *  student data entry part
	 * 
	 * */

	// student Registraton
	@PostMapping("/registration")
	public ResponseEntity<?> studentRegistration(@RequestBody Student student) {
		return null;
	}

	// course updation
	@PostMapping("/course")
	public ResponseEntity<?> studentCourse(@RequestBody Course course) {
		return null;
	}

	// store Credential
	@PostMapping("/credential")
	public ResponseEntity<?> studentCredential(@RequestBody Credential credential) {
		return null;
	}

	// store project details
	@PostMapping("/project")
	public ResponseEntity<?> studentProject(@RequestBody Project project) {
		return null;
	}

	// store placement details
	@PostMapping("/placement")
	public ResponseEntity<?> studentPlacement(@RequestBody PlacementDetails placementDetails) {
		return null;
	}

	// store student resume
	@PostMapping("/resume")
	public ResponseEntity<?> studentResume(@RequestBody MultipartFile studentResume) {
		// create resume class instance and set the property by fetching multipart file
		// and then store the resume instance
		// in the database
		return null;
	}

	// store student photo
	@PostMapping("/photo")
	public ResponseEntity<?> studentPhoto(@RequestBody MultipartFile studentPhoto) {
		// create Photo class instance and set the property by fetching multipart file
		// and then store the Photo instance
		// in the database
		return null;
	}

	/*-----------------------------------------------------------------------------------------------------------------------------------
	 *  student data fetching part
	 * 
	 * */

	 
}
