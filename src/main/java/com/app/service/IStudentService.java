package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.DtoToInsertPlacementDetails;
import com.app.dto.SendPlacementDetailsDto;
import com.app.dto.SuccessMessageDto;
import com.app.pojos.BaseEntity;
import com.app.pojos.Credential;
import com.app.pojos.PlacementDetails;
import com.app.pojos.Project;
import com.app.pojos.Question;
import com.app.pojos.Student;
import com.app.pojos.StudentPhoto;
import com.app.pojos.StudentResume;

public interface IStudentService {

	//Student studentRegistration(int year, String batch, String courseName, Student student);
	
	int addStudentResume(int sid, MultipartFile studentResume) throws IOException;

	int addStudentPhoto(int sid, MultipartFile studentPhoto) throws IOException;

	int addStudentProject(int sid, Project project);
	// -------------------------------------------------------------

	public SuccessMessageDto  addStudentPlacement(int sid, DtoToInsertPlacementDetails placementDto);

	public List<Student> allStudentDetails();

	public List<Project> getAllProject(int sid);

	public StudentResume downloadResume(int sid);

    public	List<SendPlacementDetailsDto> getAllPlacementDetails(int sid);

	public   List<Question> getAllQuestion(int cid);

	//------------------------------------------------------------

	// all fetching method
	
	 public SuccessMessageDto studentRegister(Student student);

	 
	 // add qustion
	 SuccessMessageDto addQuestion(int cid,Question question);
	 
	 // download image
	 StudentPhoto downloadPhoto(int sid);
	 
	 public List<Student> findAllStudent();
	 
	 
	 /**
	  * update student details------------------------------------------------------------------------------------------------------------
	  */
	 SuccessMessageDto updateStudentDetails(Student std);
}
