package com.app.Contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Credential;
import com.app.service.ICredentialService;

@RestController
@RequestMapping("/credential")
public class LoginController {

	 @Autowired
	 private ICredentialService credService;
	 
	 @PostMapping("/register")
	 public ResponseEntity<?>  saveCredential(@RequestBody Credential cred){
		 return ResponseEntity.ok(credService.saveCredential(cred));
	 }
}
