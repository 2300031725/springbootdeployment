package com.klef.fsad.sdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.sdp.model.Tutor;
import com.klef.fsad.sdp.repository.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService
{
	@Autowired
    private TutorRepository tutorRepository;
	
	@Override
	public Tutor checktutorlogin(String username, String password) 
	{
		return tutorRepository.findByUsernameAndPassword(username, password);
	}

}
