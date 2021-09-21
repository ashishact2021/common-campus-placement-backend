package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

}
