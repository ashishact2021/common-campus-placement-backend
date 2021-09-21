package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CredentialRepository;
import com.app.pojos.Credential;

@Service	
public class CredentialService implements ICredentialService{

	 @Autowired
	 private CredentialRepository credRepo;

	@Override
	public Credential saveCredential(Credential transientCred) {
	     return credRepo.save(transientCred);
	}
	 
	 
}
