package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CompanyRepository;
import com.app.dto.SuccessMessageDto;
import com.app.pojos.Company;

@Service
@Transactional
public class AdminService implements IAdminService{

	@Autowired
	private CompanyRepository companyRepo;
	
	public AdminService() {
		System.out.println("AdminService.AdminService()");
	}

	// add compnay  details 
	@Override
	public SuccessMessageDto addCompany(Company company) {
		companyRepo.save(company);
		return new SuccessMessageDto("Company Details added successfully");
	}

}
