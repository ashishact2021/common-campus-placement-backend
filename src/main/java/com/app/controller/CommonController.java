package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Credential;
import com.app.service.ICommonService;

@RestController
@RequestMapping("/common")
@CrossOrigin(origins = "http://localhost:3000")

public class CommonController {

	 @Autowired
	 private ICommonService commonService;
	 
	 
	public CommonController() {
		System.out.println("CommonController.CommonController()");
	}

	// for user login authentication
		//url="http://localhost:8080/student/login"
		@PostMapping("/login")
		public ResponseEntity<?> validateLogin(@RequestBody Credential credential){
			return ResponseEntity.ok(commonService.validateLogin(credential));
		}
}
