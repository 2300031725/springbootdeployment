package com.klef.fsad.sdp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tutor_table")
public class Tutor
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tutor_id")
    private int id;
    @Column(name = "tutor_name",length = 50,nullable = false)
    private String name;
    @Column(name = "tutor_gender",length = 10,nullable = false)
    private String gender;
    @Column(name = "tutor_dob",length = 20,nullable = false)
    private String dob;
    @Column(name = "tutor_email",length = 50,nullable = false,unique=true)
    private String email;
    @Column(name = "tutor_uname",length = 50,nullable = false,unique=true)
    private String username;
    @Column(name = "tutor_pwd",length = 50,nullable = false)
    private String password;
    @Column(name = "tutor_mobileno",length = 20,nullable = false,unique=true)
    private String mobileno;
    @Column(name = "tutor_experience",length = 50,nullable = false)
    private String experience;
    @Column(name = "tutor_location",length = 50,nullable = false)
    private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
