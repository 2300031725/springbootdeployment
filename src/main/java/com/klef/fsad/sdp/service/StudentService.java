package com.klef.fsad.sdp.service;

import java.util.List;

import com.klef.fsad.sdp.model.BookSession;
import com.klef.fsad.sdp.model.Session;
import com.klef.fsad.sdp.model.Student;

public interface StudentService 
{
  public String studentregistration(Student student);
  public Student checkstudentlogin(String username,String password);
  
  public String studentupdateprofile(Student student);
  
  public List<Session> viewallsessions();
  
  public Student getStudentById(int sid);
  public Session getSessionById(int sid);
  
  public String booksession(BookSession bookSession);
  public List<BookSession> getbookedsessionsByStudent(int sid);
}
