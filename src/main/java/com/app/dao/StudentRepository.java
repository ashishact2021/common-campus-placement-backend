package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Credential;
import com.app.pojos.Student;

public interface StudentRepository extends  JpaRepository<Student,Integer> {

	 Optional<Student> findByCredential(Credential cred);
}
