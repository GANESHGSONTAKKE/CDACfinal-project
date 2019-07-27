package com.cdac.project.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.project.faculty.model.Applicant;
import com.cdac.project.faculty.repository.ApplicantDaoImpl;

@Controller
public class FacultyRouteController {

    @RequestMapping("/")
    public String indexApplicant() {
        return "faculty/applicant/dashboard/index";
    }
    
    @RequestMapping("/signup")
    public String signup(Model model) {
    	model.addAttribute("applicant", new Applicant());
        return "faculty/applicant/signup";
    }
    
    @RequestMapping("/application")
    public String applicationform(Model model) {
    	model.addAttribute("applicant",new Applicant());
        return "faculty/applicant/dashboard/application";
    }
    
    @RequestMapping("/status")
    public String status() {
        return "faculty/applicant/dashboard/status";
    }
    
    @RequestMapping("/resume_upload")
    public String resumeUpload() {
    	return "faculty/applicant/dashboard/resume_upload";
    }
    
    // Admin Side Routes
    
    @RequestMapping("/fadmin")
    public String indexAdmin() {
        return "faculty/admin/dashboard/index";
    }
    
    @RequestMapping("/fadmin/listApplicant")
    public String listApplicant() {
        return "faculty/admin/dashboard/listApplicant";
    }
    @RequestMapping("/fadmin/Faculty")
    public String Faculty() {
        return "faculty/admin/dashboard/Faculty";
    }
    @RequestMapping("/fadmin/FacultyBasedModule")
    public String FacultyBasedModule() {
        return "faculty/admin/dashboard/FacultyBasedModule";
    }
    @RequestMapping("/fadmin/ShorlistForInterview")
    public String ShorlistForInterview() {
        return "faculty/admin/dashboard/ShortlistForInterview";
    }
    

    
	@Autowired
	ApplicantDaoImpl c;
	
    @RequestMapping("/insert")
    public String insert() {
    	
    	System.out.print("Helllll");
    	Applicant obj = new Applicant("amit@gmail.com", "98989098980", "password");
    	
    	c.addApplicant(obj);
    	
		return "Page inserted";
    	
    }

}
