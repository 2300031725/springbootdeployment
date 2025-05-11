package com.klef.fsad.sdp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.sdp.model.BookSession;
import com.klef.fsad.sdp.model.Session;
import com.klef.fsad.sdp.model.Student;
import com.klef.fsad.sdp.repository.BookSessionRepository;
import com.klef.fsad.sdp.repository.SessionRepository;
import com.klef.fsad.sdp.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
    private StudentRepository studentRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private BookSessionRepository bookSessionRepository;
	
	@Override
	public String studentregistration(Student student) 
	{
		studentRepository.save(student);
		return "Student Registered Successfully";
	}

	@Override
	public Student checkstudentlogin(String username, String password) 
	{
		return studentRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public String studentupdateprofile(Student student) {
		Optional<Student> object	= studentRepository.findById(student.getId());
		
		String msg = null;
			  
		  if(object.isPresent())
		  {
			  Student s = object.get();
			  
			  s.setName(student.getName());
			  s.setDob(student.getDob());
			  s.setMobileno(student.getMobileno());
			  s.setEmail(student.getEmail());
			  s.setPassword(student.getPassword());
			  s.setLocation(student.getLocation());
			  
			  studentRepository.save(student);
			  
			  msg = "Student Profile Updated Successfully";
		  }
		  else
		  {
			  msg = "Student ID Not Found to Update";
		  }
		  return msg;
	}

	@Override
	public List<Session> viewallsessions() {
		return sessionRepository.findAll();
	}

	@Override
	public Student getStudentById(int sid) {
		return studentRepository.findById(sid).orElse(null);
	}

	@Override
	public Session getSessionById(int sid) {
		return sessionRepository.findById(sid).orElse(null);
	}

	@Override
	public String booksession(BookSession bookSession) {
		bookSessionRepository.save(bookSession);
		return "Session Booked Successfully";
	}

	@Override
	public List<BookSession> getbookedsessionsByStudent(int sid) {
		Student student = studentRepository.findById(sid).orElse(null);
		return bookSessionRepository.findByStudent(student);
	}

}
