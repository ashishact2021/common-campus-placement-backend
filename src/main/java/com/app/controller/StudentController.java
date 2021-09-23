package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Credential;
import com.app.pojos.PlacementDetails;
import com.app.pojos.Project;
import com.app.pojos.Question;
import com.app.pojos.Student;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	 @Autowired
	 private IStudentService studentService;
	
	// default const
	public StudentController() {
		System.out.println("StudentController.StudentController()");
	}

	/*-----------------------------------------------------------------------------------------------------------------------------------
	 *  student data entry part
	 * 
	 * */

	// student Registraton
	@PostMapping("/registration/{year}/{batch}/{courseName}")
	public ResponseEntity<?> studentRegistration(@PathVariable int year,@PathVariable String batch,@PathVariable String courseName,@RequestBody Student student) {	
		return new ResponseEntity<>(studentService.studentRegistration(year, batch, courseName, student).getId(), HttpStatus.CREATED);
		
	}


	// store Credential
	@PostMapping("/credential/{sid}")
	public ResponseEntity<?> studentCredential(@PathVariable int sid,@RequestBody Credential credential) {
		return ResponseEntity.ok(studentService.studentCredential(sid, credential));
	}

	// store project details
	@PostMapping("/project/{sid}")
	public ResponseEntity<?> studentProject(@PathVariable int sid,@RequestBody Project project) {
		return ResponseEntity.ok(studentService.studentProject(sid, project));
	}

	

	// store student resume
	@PostMapping("/resume/{sid}")
	public ResponseEntity<?> studentResume(@PathVariable int sid,@RequestParam MultipartFile studentResume) throws IOException {
		// create resume class instance and set the property by fetching multipart file
		// and then store the resume instance
		// in the database
	//	studentResume.transferTo(new File("E:\\temp\\"+studentResume.getOriginalFilename()));
		return ResponseEntity.ok(studentService.studentResume(sid, studentResume));
	}

	// store student photo
	@PostMapping("/photo/{sid}")
	public ResponseEntity<?> studentPhoto(@PathVariable int sid,@RequestParam MultipartFile studentPhoto) throws IOException {
		// create Photo class instance and set the property by fetching multipart file
		// and then store the Photo instance
		// in the database
		return ResponseEntity.ok(studentService.studentPhoto(sid, studentPhoto));
	}

	
	// for user login authentication
	@PostMapping("/login")
	public ResponseEntity<?> validateLogin(@RequestBody Credential credential){
		return ResponseEntity.ok(studentService.validateLogin(credential));
	}
//----------------------------------------------------------------------------------------------------	
	// upload project 
	@PostMapping("/project/{sid}")
	public ResponseEntity<?> uploadProject(@PathVariable int sid, @RequestBody Project project){
		return null;
	}
	
	// store placement details
		@PostMapping("/placement")
		public ResponseEntity<?> studentPlacement(@RequestBody PlacementDetails placementDetails) {
			return null;
		}
	
	
	
	/*-----------------------------------------------------------------------------------------------------------------------------------
	                                                                     *  student data fetching part* */

		
		
   // find all the student based on the year , batch , course
		@PostMapping("/allStudent/{year}/{batch}/{course}")
		public List<Student> allStudentInParticularCourse(@PathVariable int year, @PathVariable String batch, @PathVariable String course){
			return null;
		}
	
	// find all the  project of any particular student
	@PostMapping("/fetch/project/{sid}")
	public   List<Project>  getAllProject(@PathVariable int sid){
		return null;
	}
	   
	   
	   // download resume
	   @PostMapping("/download/resume/{sid}")
	public  ResponseEntity<?>  downloadResume(@PathVariable int sid){
		   return null;
	   }
	   
	   
	   // find all the placement details of  any particular student
	   // use dto object to store placementDetails and comany name as one object to send the client  
	   @PostMapping("/fetch/placementdetails/{sid}")
       List<?> getAllPlacementDetails(@PathVariable int sid){
		   return null;
	   }
	   // find all the question of a particual company
	   @PostMapping("/question/{cid}")
	public   List<Question> getAllQuestion(){
		   return null;
	   }
	   
	   
	   
	
	 
}
