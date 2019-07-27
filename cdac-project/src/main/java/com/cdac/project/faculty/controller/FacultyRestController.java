package com.cdac.project.faculty.controller;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.project.faculty.service.ApplicantService;


@RestController
@RequestMapping("/api/applicants")
public class FacultyRestController {
	

	@Autowired
	private ApplicantService applicantService; 
	
	@GetMapping(path="/", produces="application/json")
	public HashMap getApplicants(){
		
		HashMap m = new HashMap();
		m.put("data", applicantService.listApplicants());
		
		return m;
		
		
	}
	
	
}
