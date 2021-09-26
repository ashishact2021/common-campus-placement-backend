package com.app.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.CourseRepository;
import com.app.dto.DtoToInsertPlacementDetails;
import com.app.pojos.Credential;
import com.app.pojos.Project;
import com.app.pojos.Student;
import com.app.pojos.StudentResume;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {

	 @Autowired
	 private IStudentService studentService;
	
	 @Autowired
	 private CourseRepository courseRepo;
	 
	// default const
	public StudentController() {
		System.out.println("StudentController.StudentController()");
	}

	/*-----------------------------------------------------------------------------------------------------------------------------------
	 *  student data entry part
	 * 
	 * */

	/*
	 * // student Registraton
	 * 
	 * @PostMapping("/registration/{year}/{batch}/{courseName}") public
	 * ResponseEntity<?> studentRegistration(@PathVariable int year,@PathVariable
	 * String batch,@PathVariable String courseName,@RequestBody Student student) {
	 * return new ResponseEntity<>(studentService.studentRegistration(year, batch,
	 * courseName, student).getId(), HttpStatus.CREATED);
	 * 
	 * }
	 */
	
	
 // url="http://localhost:8080/student/registration"
	// controller to register the student
@PostMapping("/registration")
public ResponseEntity<?> register(@RequestBody @Valid Student student) {	 
   return ResponseEntity.status(HttpStatus.ACCEPTED).body( studentService.studentRegister(student));
}

	// store project details
//url="http://localhost:8080/student/add/project/{sid}"
	@PostMapping("/add/project/{sid}")
	public ResponseEntity<?> studentProject(@PathVariable int sid,@RequestBody Project project) {
		return ResponseEntity.ok(studentService.addStudentProject(sid, project));
	}

	

	// store student resume into the data base
	//url="http://localhost:8080/student/add/resume/{sid}"
	@PostMapping("/add/resume/{sid}")
	public ResponseEntity<?> studentResume(@PathVariable int sid,@RequestParam MultipartFile studentResume) throws IOException {
		// create resume class instance and set the property by fetching multipart file
		// and then store the resume instance
		// in the database
	//	studentResume.transferTo(new File("E:\\temp\\"+studentResume.getOriginalFilename()));
		return ResponseEntity.ok(studentService.addStudentResume(sid, studentResume));
	}

	// store student photo
	//url="http://localhost:8080/student/add/photo/{sid}"
	@PostMapping("/add/photo/{sid}")
	public ResponseEntity<?> studentPhoto(@PathVariable int sid,@RequestParam MultipartFile studentPhoto) throws IOException {
		// create Photo class instance and set the property by fetching multipart file
		// and then store the Photo instance
		// in the database
		return ResponseEntity.ok(studentService.addStudentPhoto(sid, studentPhoto));
	}

	
	// for user login authentication
	//url="http://localhost:8080/student/login"
	@PostMapping("/login")
	public ResponseEntity<?> validateLogin(@RequestBody Credential credential){
		return ResponseEntity.ok(studentService.validateLogin(credential));
	}
	
	// store placement details
	//url="http://localhost:8080/student/add/placement/{sid}"
		@PostMapping("add/placement/{sid}")
		public ResponseEntity<?> studentPlacement(@PathVariable int sid,@RequestBody DtoToInsertPlacementDetails placementDto) {
			return ResponseEntity.ok( studentService.addStudentPlacement(sid, placementDto));
		}
	
	
	
	/*-----------------------------------------------------------------------------------------------------------------------------------
	                                                                     *  student data fetching part* */

		
		
   // find all the student based on the year , batch , course
		// create a student dto to send only requred  field
		//url="http://localhost:8080/student/get/allStudent"	
		@GetMapping("/get/allStudent")
		public List<Student> findAllStudent(){
			return studentService.findAllStudent();
		}
	
	// find all the  project of any particular student
		//url="http://localhost:8080/student/fetch/project/{sid}"	
	@GetMapping("/fetch/project/{sid}")
	public   List<Project>  getAllProject(@PathVariable int sid){
		return studentService.getAllProject(sid);
	}
	   
	   
	   // download resume from database
	//url="http://localhost:8080/student/download/resume/{sid}"	
	// download resume from database
		@GetMapping("/download/resume/{sid}")
		public ResponseEntity<?> downloadResume(@PathVariable int sid) throws IOException {
			StudentResume downloadResume = studentService.downloadResume(sid);
			System.out.println(downloadResume.getResumeName());
			System.out.println("in side download Response controller");
			String encodedString = Base64.getEncoder().encodeToString(downloadResume.getResumeContent());
			byte[] resume = Base64.getDecoder().decode(encodedString);
			return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.APPLICATION_PDF).body(resume); 

		}

	   
	   
	   // find all the placement details of  any particular student
	   // use dto object to store placementDetails and comany name as one object to send the client  
	 //url="http://localhost:8080/student/fetch/placementdetails/{sid}"	
	   @GetMapping("/fetch/placementdetails/{sid}")
       List<?> getAllPlacementDetails(@PathVariable int sid){
		   return studentService.getAllPlacementDetails(sid);
	   }
	   
	   
	  
	   
	   // download the photo of the a particular student
	   @GetMapping("/download/photo/{sid}")
	   public ResponseEntity<?> downloadPhoto(@PathVariable int sid) {
		  return ResponseEntity.ok(studentService.downloadPhoto(sid));
	   }
	   
	
	   
	 
}
