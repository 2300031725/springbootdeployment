package com.klef.fsad.sdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsad.sdp.dto.SessionDTO;
import com.klef.fsad.sdp.model.BookSession;
import com.klef.fsad.sdp.model.Session;
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
   
   @PostMapping("/addsession")
   public ResponseEntity<String> addsession(@RequestBody SessionDTO dto) 
   {
       try 
       {
           Tutor tutor = tutorService.getTutorById(dto.tutor_id);

           Session session = new Session();
           session.setSubject(dto.subject);
           session.setTutorname(dto.tutorname);
           session.setDescription(dto.description);
           session.setDuration(dto.duration);
           session.setPrice(dto.price);
           session.setTutor(tutor);

           String output = tutorService.addsession(session);
           return ResponseEntity.ok(output); // 200 - success
       } 
       catch (Exception e) 
       { 
    	   return ResponseEntity.status(500).body("Failed to Add Session: " + e.getMessage());
       }
   }
   
   @GetMapping("/viewsessionsbytutor/{id}")
   public ResponseEntity<List<Session>> viewsessionsbytutor(@PathVariable int id) 
   {
       List<Session> sessions = tutorService.viewsessionsbytutor(id);
       return ResponseEntity.ok(sessions);
   }


   @GetMapping("/viewbookingsbytutor/{tutorId}")
   public ResponseEntity<List<BookSession>> viewBookingsByTutor(@PathVariable int tutorId) 
   { 
       List<BookSession> sessions = tutorService.getbookingsbyTutor(tutorId);
       return ResponseEntity.ok(sessions);
   }

   @GetMapping("/updatebookingstatus")
   public ResponseEntity<String> updateBookingStatus(@RequestParam int id,@RequestParam String status) 
   { 
       try
       {
    	   String output = tutorService.updatebookingstatus(id, status);
    	   return ResponseEntity.ok(output);
       }
       catch (Exception e) 
       {
    	   System.out.println(e.getMessage());
    	   return ResponseEntity.status(500).body("Error:" + e.getMessage());
	   }
   }

}
