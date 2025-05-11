package com.klef.fsad.sdp.controller;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klef.fsad.sdp.dto.SubjectDTO;
import com.klef.fsad.sdp.model.Subject;
import com.klef.fsad.sdp.service.SubjectService;


@RestController
@RequestMapping("/subject")
@CrossOrigin("*")
public class SubjectController 
{
	 @Autowired
	 private SubjectService subjectService;
	
	 @PostMapping("/addsubject")
	 public ResponseEntity<String> addSubject(
	         @RequestParam String category,
	         @RequestParam String name,
	         @RequestParam String description,
	         @RequestParam double cost,
	         @RequestParam String url,
	         @RequestParam("subjectimage") MultipartFile file) {
	     try {
	         byte[] bytes = file.getBytes();
	         Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

	         Subject s = new Subject();
	         s.setCategory(category);
	         s.setName(name);
	         s.setDescription(description);
	         s.setCost(cost);
	         s.setUrl(url);
	         s.setImage(blob);

	         String output = subjectService.addSubject(s);
	         return ResponseEntity.ok(output);

	     } catch (Exception e) {
	         return ResponseEntity.status(500).body("Error: " + e.getMessage());
	     }
	 }

	 
	 // to view or display all products
	 
	 @GetMapping("viewallsubjects")
	 public ResponseEntity<List<SubjectDTO>> viewallsubjects() 
	 {
	     List<Subject> subjectList = subjectService.viewallSubjects();
	     List<SubjectDTO> subjectDTOList = new ArrayList<>();

	     for (Subject s : subjectList) {
	    	 SubjectDTO dto = new SubjectDTO();
	         dto.setId(s.getId());
	         dto.setCategory(s.getCategory());
	         dto.setName(s.getName());
	         dto.setDescription(s.getDescription());
	         dto.setCost(s.getCost());
	         dto.setUrl(s.getUrl());
	         subjectDTOList.add(dto);
	     }

	     return ResponseEntity.ok(subjectDTOList);
	 }
	   // to display product image by id
	   
	@GetMapping("displaysubjectimage")
	public ResponseEntity<byte[]> displaysubjectimage(@RequestParam int id) throws Exception
	{
		Subject subject =  subjectService.viewSubjectById(id);
	  byte [] imageBytes = null;
	  imageBytes = subject.getImage().getBytes(1,(int) subject.getImage().length());

	  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	  //return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(imageBytes);
	}
	
	// to view or display product by id

	   @PostMapping("displaysubjectbyid")
	   public ResponseEntity<SubjectDTO> displaysubjectdemo(@RequestParam int sid)
	   {
		   Subject s=subjectService.viewSubjectById(sid);
		   
		   SubjectDTO dto = new SubjectDTO();
		     
	         dto.setId(s.getId());
	         dto.setCategory(s.getCategory());
	         dto.setName(s.getName());
	         dto.setDescription(s.getDescription());
	         dto.setCost(s.getCost());
	         dto.setUrl(s.getUrl());
		   
		   return ResponseEntity.ok(dto);
	   }
	   
}