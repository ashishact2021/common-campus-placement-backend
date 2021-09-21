package com.app.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Credential;
import com.app.pojos.Role;

@SpringBootTest
public class CredentialDao {
	
	@Autowired
	private CredentialRepository cred;
	
	
	@Test
	public void InsertCredential() {
		System.out.println("CredentialDao.InsertCredential()");
		List<Credential> credential=Arrays.asList(new Credential("ashish", "ashish123@",Role.STUDENT),new Credential("abhilash","abhi123@",Role.STUDENT));
		cred.saveAll(credential);
	}
}
