package com.klef.fsad.sdp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "session_table")
public class Session 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false,length = 100)
  private String subject;
  @Column(nullable = false,length = 100)
  private String tutorname;
  @Column(nullable = false,length = 500)
  private String description;
  @Column(nullable = false)
  private int duration;
  @Column(nullable = false)
  private double price;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "tutor_id") 
  private Tutor tutor;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public String getTutorname() {
	return tutorname;
}

public void setTutorname(String tutorname) {
	this.tutorname = tutorname;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getDuration() {
	return duration;
}

public void setDuration(int duration) {
	this.duration = duration;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public Tutor getTutor() {
	return tutor;
}

public void setTutor(Tutor tutor) {
	this.tutor = tutor;
}



}
