package com.klef.fsad.sdp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.sdp.model.Admin;
import com.klef.fsad.sdp.model.Student;
import com.klef.fsad.sdp.model.Tutor;
import com.klef.fsad.sdp.repository.AdminRepository;
import com.klef.fsad.sdp.repository.SessionRepository;
import com.klef.fsad.sdp.repository.StudentRepository;
import com.klef.fsad.sdp.repository.TutorRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
    private AdminRepository adminRepository;
	
	@Autowired
    private TutorRepository tutorRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public Admin checkadminlogin(String username, String password) 
	{
		return adminRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public String addtutor(Tutor tutor) 
	{
		tutorRepository.save(tutor);
		return "Tutor Added Successfully";
	}

	@Override
	public List<Tutor> displaytutors() 
	{
		return tutorRepository.findAll();
	}

	@Override
	public List<Student> displaystudents() 
	{
		return studentRepository.findAll();
	}

	@Override
	public String deletestudent(int sid) 
	{
	    Optional<Student> student = studentRepository.findById(sid);
	    
	    if (student.isPresent()) 
	    {	
	    	studentRepository.deleteById(sid);
	        return "Student Deleted Successfully";
	    } 
	    else 
	    {
	        return "Student ID Not Found";
	    }
	}

	@Override
	public String deletetutor(int tid) {
		Optional<Tutor> tutor = tutorRepository.findById(tid);
	    
	    if (tutor.isPresent()) 
	    {	
	    	tutorRepository.deleteById(tid);
	        return "Tutor Deleted Successfully";
	    } 
	    else 
	    {
	        return "Tutor ID Not Found";
	    }
	}

	@Override
	public long displaystudentcount() {
		return studentRepository.count();
	}

	@Override
	public long displaytutorcount() {
		return tutorRepository.count();
	}

	@Override
	public long displaysessioncount() {
		return sessionRepository.count();
	}

}
