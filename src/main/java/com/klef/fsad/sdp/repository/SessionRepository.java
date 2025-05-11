package com.klef.fsad.sdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.fsad.sdp.model.Session;
import com.klef.fsad.sdp.model.Tutor;

@Repository
public interface SessionRepository extends JpaRepository<Session,Integer>{
	public List<Session> findByTutor(Tutor tutor);
	
	 @Query("select count(s) from Session s")
	 public long sessioncount();
}
