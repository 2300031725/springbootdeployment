package com.klef.fsad.sdp.service;

import java.util.List;

import com.klef.fsad.sdp.model.Admin;
import com.klef.fsad.sdp.model.Student;
import com.klef.fsad.sdp.model.Tutor;

public interface AdminService 
{
  public Admin checkadminlogin(String username,String password);
  
  public String addtutor(Tutor tutor);
  public List<Tutor> displaytutors();
  public String deletetutor(int tid);
  
  public List<Student> displaystudents();
  public String deletestudent(int sid);
  
  public long displaystudentcount();
  public long displaytutorcount();
  public long displaysessioncount();
}
