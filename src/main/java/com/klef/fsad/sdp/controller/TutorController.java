package com.klef.fsad.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsad.sdp.model.Tutor;
import com.klef.fsad.sdp.service.TutorService;

@RestController
@RequestMapping("/tutor")
@CrossOrigin("*")
public class TutorController 
{
   @Autowired
   private TutorService tutorService;
	   
   @PostMapping("/checktutorlogin")
   public ResponseEntity<?> checktutorlogin(@RequestBody Tutor tutor) 
   {
       try 
       {
    	   Tutor t = tutorService.checktutorlogin(tutor.getUsername(), tutor.getPassword());

           if (t!=null) 
           {
               return ResponseEntity.ok(t); // if login is successful
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
