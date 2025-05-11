package com.klef.fsad.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.fsad.sdp.model.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Integer>
{
  public Tutor findByUsernameAndPassword(String username, String password);
  
  @Query("select count(t) from Tutor t")
  public long tutorcount();
}
