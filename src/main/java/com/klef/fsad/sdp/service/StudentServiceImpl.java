package com.klef.fsad.sdp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.sdp.model.BookSession;
import com.klef.fsad.sdp.model.Session;
import com.klef.fsad.sdp.model.Student;
import com.klef.fsad.sdp.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
    private StudentRepository studentRepository;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Session> viewallsessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentrById(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getSessionById(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String booksession(BookSession bookSession) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookSession> getbookedsessionsByStudent(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

}
