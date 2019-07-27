package com.cdac.project.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.project.faculty.model.Applicant;
import com.cdac.project.faculty.service.ApplicantService;

@Controller
public class ApplicantionController {
	
	@Autowired
	private ApplicantService applicantService;
	
	@RequestMapping(value="/submitApplication",method=RequestMethod.POST)
	public String submitApplication(Model model,@ModelAttribute Applicant applicant) {
		applicantService.addApplicant(applicant);
		model.addAttribute("success",new Boolean(true));
		return "faculty/applicant/dashboard/application";
	}
	
	
	@RequestMapping(value = "/signupApplicant",method=RequestMethod.POST)
	public String signupApplicant() {
		return "faculty/applicant/signup";
	}
	
}
