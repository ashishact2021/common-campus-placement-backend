package com.app.service;

import static com.app.CustomCommandLineRunner.PHOTO_PATH;
import static com.app.CustomCommandLineRunner.RESUME_PATH;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exception.CourseNotFoundException;
import com.app.custom_exception.InvalidCredentialException;
import com.app.dao.AdminRepository;
import com.app.dao.CompanyRepository;
import com.app.dao.CourseRepository;
import com.app.dao.CredentialRepository;
import com.app.dao.StudentRepository;
import com.app.dto.DtoToInsertPlacementDetails;
import com.app.dto.SendPlacementDetailsDto;
import com.app.dto.SuccessMessageDto;
import com.app.pojos.Course;
import com.app.pojos.Credential;
import com.app.pojos.PlacementDetails;
import com.app.pojos.Project;
import com.app.pojos.Question;
import com.app.pojos.Round;
import com.app.pojos.SelectionStatus;
import com.app.pojos.Student;
import com.app.pojos.StudentPhoto;
import com.app.pojos.StudentResume;

@Service
@Transactional
public class StudentService implements IStudentService{
	 
	@Autowired
	private StudentRepository  studentRepo;
	
	@Autowired
	 private CourseRepository courseRepo;
	
	@Autowired 
	private CredentialRepository credRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private EntityManager  manager;
	
	@Autowired
	private AdminRepository adminRepo;
	

	// student registration
	@Override
	 public SuccessMessageDto studentRegister(Student student) {
		 Optional<Course> courseOptional = courseRepo.findByCourseNameAndBatchAndYear(student.getCourse().getCourseName(),
				 student.getCourse().getBatch(), student.getCourse().getYear());
	     Course course=  courseOptional.orElseThrow(()-> new CourseNotFoundException("can not the find the course !!"));
	     course.getStudents().add(student);
	     student.setCourse(course);
	     return new SuccessMessageDto("User Registered successfully");
	 }
	// store project details
	@Override
	public int addStudentProject(int sid,Project project) {
		Student student = studentRepo.findById(sid).get();
		student.getProjects().add(project);
		studentRepo.save(student);
		return sid;
	}

	
	// store student resume
		@Override
		public int addStudentResume(int sid, MultipartFile studentResume) throws IOException {
			// create resume class instance and set the property by fetching multipart file
			// and then store the resume instance
			// in the database
			StudentResume stdResume = new StudentResume();
			stdResume.setResumeName(studentResume.getOriginalFilename());
			stdResume.setResumeContent(studentResume.getBytes());

			Student student = studentRepo.findById(sid).get();
			student.setResume(stdResume);
			studentRepo.save(student);
			studentResume.transferTo(new File(RESUME_PATH + "\\" + studentResume.getOriginalFilename()));
			return sid;
		}

		// store student photo
		@Override
		public int addStudentPhoto(int sid, MultipartFile studentPhoto) throws IOException {
			// create Photo class instance and set the property by fetching multipart file
			// and then store the Photo instance
			// in the database
			StudentPhoto stdPhoto = new StudentPhoto();
			stdPhoto.setPhoto(studentPhoto.getBytes());

			Student student = studentRepo.findById(sid).get();
			student.setPhoto(stdPhoto);
			studentRepo.save(student);
			studentPhoto.transferTo(new File(PHOTO_PATH + "\\" + studentPhoto.getOriginalFilename()));
			return sid;
		}


	

	@Override
	public SuccessMessageDto addStudentPlacement(int sid, DtoToInsertPlacementDetails placementDetails) {
		System.out.println(placementDetails.getCompanyName());
		// create the placement details pojo
		PlacementDetails transientPlacementDetais =new PlacementDetails();
		transientPlacementDetais.setIsSelected(SelectionStatus.valueOf(placementDetails.getIsSelected().toUpperCase()));
		transientPlacementDetais.setRound(Round.valueOf(placementDetails.getRound().toUpperCase()));
		transientPlacementDetais.setCompany(companyRepo.findByName(placementDetails.getCompanyName().toUpperCase()));
	
		// insert the RECORD
		Student student = studentRepo.findById(sid).get();
	    student.getPlacementDetails().add(transientPlacementDetais);
	    studentRepo.save(student);
	    
		return new SuccessMessageDto("student placement datials is added successfully");
	}

   // not to implement 
	@Override
	public List<Student> allStudentDetails() {
		// TODO Auto-generated method stub
		return null;
	}


	// get all project
	@Override
	public List<Project> getAllProject(int sid) {
    Student student = studentRepo.findById(sid).get();
    System.out.println(student.getDob());
		return student.getProjects();
	}


	
	// student resume download 
	@Override
	public StudentResume downloadResume(int sid) {
		
		 return studentRepo.findByIdWithResume(sid).get().getResume();
	}
	
	
	// download the photo 
		@Override
		public StudentPhoto downloadPhoto(int sid) {
			return studentRepo.findByIdWithPhoto(sid).get().getPhoto();
		}


		
		// get all the placement detalis of a particular student
	@Override
	public List<SendPlacementDetailsDto> getAllPlacementDetails(int sid) {
		// find the student persistant pojo
	     Student student = studentRepo.findById(sid).get();
	     //  find the list of his placemet details
	     List<PlacementDetails> placementDetails = student.getPlacementDetails();
	    //create the list of SendPlacementDeailsDto
	     List<SendPlacementDetailsDto> placementDetailsOfStudent=new ArrayList<SendPlacementDetailsDto>();
	     placementDetails.forEach(e->{
	    	 // create and populate the plaementDetailsDto
	    	  SendPlacementDetailsDto  pd=new SendPlacementDetailsDto();
	    	  pd.setIsSelected(e.getIsSelected().toString());
	    	  pd.setRound(e.getRound().toString());
	    	  pd.setCid(e.getCompany().getId().toString());
	    	  pd.setCompanyName(e.getCompany().getName());
	    	  
	    	  // add that in the list of placement details
	    	  placementDetailsOfStudent.add(pd);
	     });
	     // return that populated list 
		return placementDetailsOfStudent;
	}


	// get all the question based on company 
	@Override
	public List<Question> getAllQuestion(int cid) {
		return companyRepo.findById(cid).get().getQuestions();
	}

	
	// add the qustion  to any company
	@Override
	public SuccessMessageDto addQuestion(int cid, Question question) {
		 companyRepo.findById(cid).get().getQuestions().add(question);
		 return new SuccessMessageDto("question iserted successfully");
	}

	
	// return all the list of student
	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}
	
	/**
	 * update operation------------------------------------------------------------------------------------------
	 */
	@Override
	public SuccessMessageDto updateStudentDetails(Student std) {
		manager.merge(std);
		return new SuccessMessageDto("Student details updated successfully");
	}

	
}
