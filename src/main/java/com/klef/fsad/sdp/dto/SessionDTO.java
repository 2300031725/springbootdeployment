package com.klef.fsad.sdp.dto;

public class SessionDTO {
	public String subject;
    public String tutorname;
    public String description;
    public int duration;
    public double price;
    public int tutor_id;
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
	public int getTutor_id() {
		return tutor_id;
	}
	public void setTutor_id(int tutor_id) {
		this.tutor_id = tutor_id;
	}
}
