package com.klef.fsad.sdp.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "booksession_table")
public class BookSession
{
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(nullable = false)
    private String startdate;

    @Column(nullable = false)
    private String enddate;

    @Column(nullable = false)
    private int bookedsubject;

    @Column(nullable = false)
    private String status;

    // Automatically sets the booking time at record creation
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime bookingtime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getBookedsubject() {
		return bookedsubject;
	}

	public void setBookedsubject(int bookedsubject) {
		this.bookedsubject = bookedsubject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getBookingtime() {
		return bookingtime;
	}

	public void setBookingtime(LocalDateTime bookingtime) {
		this.bookingtime = bookingtime;
	}


	@Override
	public String toString() {
		return "BookSession [id=" + id + ", session=" + session + ", student=" + student + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", bookedcapacity=" + bookedsubject + ", status=" + status
				+ ", bookingtime=" + bookingtime + "]";
	}
}