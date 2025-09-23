package com.klef.fsad.sdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klef.fsad.sdp.model.BookSession;
import com.klef.fsad.sdp.model.Student;

@Repository
public interface BookSessionRepository extends JpaRepository<BookSession,Integer>{
	public List<BookSession> findByStudent(Student student);
	  
	  @Query("SELECT b from BookSession b where b.session.tutor.id = ?1")
	  public List<BookSession> getbookingsbyTutor(int tid);
	  
	  @Modifying
	  @Transactional
	  @Query("UPDATE BookSession b SET b.status = ?1 WHERE b.id = ?2")
	  public int updateStatusById(String status,int id);
}
