package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Company;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")

public class AdminController {

	@Autowired
	private IAdminService adminService;
	
	public AdminController() {
		System.out.println("AdminController.AdminController()");
	}

	
	@PostMapping("/add/company")
	ResponseEntity<?> addCompany(@RequestBody Company company){
		company.setName(company.getName().toUpperCase());
	   return ResponseEntity.status(HttpStatus.ACCEPTED).body(adminService.addCompany(company));
	}
}
