package com.crudOperation.example.service;

import java.util.List;

//import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperation.example.DTO.StudentDto;
import com.crudOperation.example.entity.BaseResponse;
import com.crudOperation.example.entity.Student;
import com.crudOperation.example.entity.Subject;
import com.crudOperation.example.repository.StudentRepository;
import com.crudOperation.example.repository.SubjectRepository;



@Service
public class StudentService {
//auto wired to inject	from repository
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SubjectRepository subjectRepository;
//post method 	 
	// public List<Student> saveAllDetails(List<Student> student) {
	//        return studentRepository.saveAll(student);
	//    }
	 
	public BaseResponse addStudent (StudentDto studentDto) {
		 BaseResponse baseResponse=new BaseResponse(); 
	        Student student = new Student();
	        Subject subject = new Subject();
	        student.setName(studentDto.getName());
	        student.setCity(studentDto.getCity());
	        student.setSubject(subject);
	        studentRepository.save(student);
	        subject.setSubjectName(studentDto.getSubjectName());
	       // subject.setSubjectName(studentDto.getSubjectName());
	      
	        subjectRepository.save(subject);
	        baseResponse.setStatusCode("200");
	        baseResponse.setStatusMsg("ID Created Successfully");
	        baseResponse.setData(student);
	        //baseResponse.setData(subject);
	       // baseResponse.setData(studentDto);
	        return baseResponse;
	}
	


	
  public List<Student> saveAllDetails(List<Student> student) {
	        return studentRepository.saveAll(student);
	    }
	    
	  
//get method	 
	 public List<Student> listAllDetails() {
	        return studentRepository.findAll();
	    }
//get by id  method	 
	 public Student getStudentDetailsByID(int id) {
	        return studentRepository.findById(id).orElse(null);
	    }
//update method	 
	 public BaseResponse updateStudentDetails(StudentDto studentDto) {
	        BaseResponse baseResponse=new BaseResponse();
	        Student existingStudent=studentRepository.findById(studentDto.getId()).orElse(null);
	        Subject subject = new Subject();
	        subject.setSubjectName(studentDto.getSubjectName());
	        existingStudent.setName(studentDto.getName());
	        existingStudent.setCity(studentDto.getCity());
	        existingStudent.setSubject(subject);
	        subject.setSubjectName(studentDto.getSubjectName());
	        studentRepository.save(existingStudent);
	        baseResponse.setStatusCode("200");
	        baseResponse.setStatusMsg("Updated Successfully");
	        baseResponse.setData(existingStudent);
	        //baseResponse.setData(subject);
	        //baseResponse.setData(studentDto);
	        return baseResponse;
   
	    }
//delete method	 
	 public BaseResponse deleteDetailsById(int id) {
		 BaseResponse baseResponse = new BaseResponse();
		  studentRepository.deleteById(id);
		  baseResponse.setStatusCode("200");
		  baseResponse.setStatusMsg("Details Deleted Succesfully");
		  return  baseResponse;
	 }


	
}