package com.klef.fsad.sdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klef.fsad.sdp.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
  public Student findByUsernameAndPassword(String username, String password);

  @Query("select s from Student s where s.gender=?1")
  public List<Student> displaystudentbygender(String gender);
  
  @Modifying
  @Transactional
  @Query("delete from Student s where s.location=?1")
  public int deletestudentbylocation(String location);
  
  @Query("select count(s) from Student s")
  public long studentcount();
}