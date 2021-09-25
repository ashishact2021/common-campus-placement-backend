package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Question;
import com.app.service.StudentService;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {

	@Autowired
   private StudentService studentService;
	public CompanyController() {
		System.out.println("CompanyController.CompanyController()");
	}
	
	// add question with the to a particualr company
		//url="http://localhost:8080/student/add/question/{sid}"
		@PostMapping("/add/question/{cid}")// cid =company id
		public ResponseEntity<?> insertQuestion(@PathVariable int cid,@RequestBody Question quetion){
			return ResponseEntity.ok(studentService.addQuestion(cid, quetion));
		}
	
		
		 // find all the question of a particual company
		 //url="http://localhost:8080/student/getall/question/{cid}"	
		   @GetMapping("/getall/question/{cid}")
		public   List<Question> getAllQuestion(@PathVariable int cid){
			   return studentService.getAllQuestion(cid);
		   }

}
