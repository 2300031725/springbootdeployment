package com.klef.fsad.sdp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.sdp.model.Subject;
import com.klef.fsad.sdp.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public String addSubject(Subject subject) {
		subjectRepository.save(subject);
		return "Subject Added Successfully";
	}

	@Override
	public List<Subject> viewallSubjects() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject viewSubjectById(int sid) {
		return subjectRepository.findById(sid).orElse(null);
	}

	@Override
	public List<Subject> viewSubjectsByCategory(String category) {
		return subjectRepository.findByCategory(category);
	}

}
