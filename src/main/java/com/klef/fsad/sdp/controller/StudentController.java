package com.klef.fsad.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
