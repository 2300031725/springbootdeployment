package com.klef.fsad.sdp.service;

import java.util.List;

import com.klef.fsad.sdp.model.Subject;

public interface SubjectService {
	public String addSubject(Subject subject);
	   public List<Subject> viewallSubjects();
	   public Subject viewSubjectById(int sid);
	   public List<Subject> viewSubjectsByCategory(String category);
}
