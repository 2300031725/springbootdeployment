package com.klef.fsad.sdp.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsad.sdp.model.BookSession;
import com.klef.fsad.sdp.model.Session;
import com.klef.fsad.sdp.model.Student;
import com.klef.fsad.sdp.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*") // * means any URL
public class StudentController 
{
   @Autowired
   private StudentService studentService;
	
   @GetMapping("/")
   public String home()
   {
	   return "Home Tutor Project";
   }
   
   @PostMapping("/registration")
   public ResponseEntity<String> studentregistration(@RequestBody Student student)
   {
	   try
	   {
		  String output = studentService.studentregistration(student);
		  return ResponseEntity.ok(output); // 200 - success
	   }
	   catch(Exception e)
	   {
//		   return ResponseEntity.status(500).body("Registration failed: " + e.getMessage());
		   return ResponseEntity.status(500).body("Student Registration Failed ...");

	   }
   }
   
   @PostMapping("/checkstudentlogin")
   public ResponseEntity<?> checkstudentlogin(@RequestBody Student student) 
   {
       try 
       {
    	   Student s = studentService.checkstudentlogin(student.getUsername(), student.getPassword());

           if (s!=null) 
           {
               return ResponseEntity.ok(s); // if login is successful
           } 
           else 
           {
               return ResponseEntity.status(401).body("Invalid Username or Password"); // if login is fail
           }
       } 
       catch (Exception e) 
       {
           return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
       }
   }
   
   @PutMapping("/updateprofile")
   public ResponseEntity<String> studentupdateprofile(@RequestBody Student student)
   {
 	  try
 	   {
 		  System.out.println(student.toString());
 		  String output = studentService.studentupdateprofile(student);
 		  return ResponseEntity.ok(output);
 	   }
 	   catch(Exception e)
 	   {
 		    System.out.println(e.getMessage());
 		    return ResponseEntity.status(500).body("Failed to Update Customer ... !!"); 
 	   }
   }

   @GetMapping("/viewallsessions")
   public ResponseEntity<List<Session>> viewallsessions()
   {
 	 List<Session> sessions =  studentService.viewallsessions();
 	 
 	 return ResponseEntity.ok(sessions); // 200 - success
   }
   
  
   @PostMapping("/booksession")
   public ResponseEntity<String> bookSession(@RequestBody BookSession bookSession) 
   {
      try
      {
    	  int bookingId = new Random().nextInt(900000) + 100000;  // 6-digit ID
          bookSession.setId(bookingId);

          Student student = studentService.getStudentById(bookSession.getStudent().getId());
          Session session = studentService.getSessionById(bookSession.getSession().getId());
         

          // Assign actual customer and event objects
          bookSession.setStudent(student);
          bookSession.setSession(session);

          // Set status to "BOOKED"
          bookSession.setStatus("BOOKED");

          String output = studentService.booksession(bookSession);

          return ResponseEntity.ok(output); // 200 - success
      }
      catch (Exception e) 
      {
    	  return ResponseEntity.status(500).body("Failed to Book an Session: " + e.getMessage());
	  }
   }

   @GetMapping("/bookedsessions/{sid}")
   public ResponseEntity<List<BookSession>> getSessionsByStudent(@PathVariable int sid) 
   {
       List<BookSession> bookedsessions =  studentService.getbookedsessionsByStudent(sid);
   	 
   	   return ResponseEntity.ok(bookedsessions); // 200 - success
   }  
}
