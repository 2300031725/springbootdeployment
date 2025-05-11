package com.klef.fsad.sdp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.sdp.model.BookSession;
import com.klef.fsad.sdp.model.Session;
import com.klef.fsad.sdp.model.Tutor;
import com.klef.fsad.sdp.repository.BookSessionRepository;
import com.klef.fsad.sdp.repository.SessionRepository;
import com.klef.fsad.sdp.repository.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService
{
	@Autowired
    private TutorRepository tutorRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private BookSessionRepository bookSessionRepository;
	
	@Override
	public Tutor checktutorlogin(String username, String password) 
	{
		return tutorRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public String addsession(Session session) {
		sessionRepository.save(session);
		return "Session Added Successfully";
	}

	@Override
	public List<Session> viewsessionsbytutor(int tid) {
		Tutor tutor = tutorRepository.findById(tid).orElse(null);
		 return sessionRepository.findByTutor(tutor);
	}

	@Override
	public Tutor getTutorById(int tid) {
		return tutorRepository.findById(tid).get();
	}

	@Override
	public List<BookSession> getbookingsbyTutor(int tid) {
		return bookSessionRepository.getbookingsbyTutor(tid);
	}

	@Override
	public String updatebookingstatus(int id, String status) {
		bookSessionRepository.updateStatusById(status,id);
		return "Booking Status Updated Successfully";
	}

}
