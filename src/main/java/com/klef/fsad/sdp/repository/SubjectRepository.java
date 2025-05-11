package com.klef.fsad.sdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsad.sdp.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
	public List<Subject> findByCategory(String category);
}