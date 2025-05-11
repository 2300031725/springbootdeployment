package com.klef.fsad.sdp.service;

import java.util.List;

import com.klef.fsad.sdp.model.BookSession;
import com.klef.fsad.sdp.model.Session;
import com.klef.fsad.sdp.model.Tutor;

public interface TutorService 
{
  public Tutor checktutorlogin(String username,String password);
  
  public String addsession(Session session);
  public List<Session> viewsessionsbytutor(int tid);
  
  public Tutor getTutorById(int tid);
  
  public List<BookSession> getbookingsbyTutor(int tid);
  
  public String updatebookingstatus(int id,String status);
}
