package com.app.service;

import com.app.pojos.Credential;

public interface ICredentialService {
  // insert the credential 
	Credential  saveCredential(Credential transientCred);
}
