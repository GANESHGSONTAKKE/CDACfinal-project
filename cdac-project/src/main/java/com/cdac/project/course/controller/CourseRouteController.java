package com.cdac.project.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseRouteController {

	
	//admin login routes
	
    @RequestMapping("/cadmin")
    public String index() {
        return "course/admin/dashboard/index";
    }

    @RequestMapping("/cadmin/batchCreation")
    public String batch_creation() {
        return "course/admin/dashboard/batchCreation";
    }
    
    @RequestMapping("/cadmin/addFaculty")
    public String add_faculty() {
        return "course/admin/dashboard/addFaculty";
    }
    
    //faculty login routes
    
    @RequestMapping("/faculty")
    public String indexfaculty() {
        return "course/faculty/dashboard/index";
    }
	
    
	
}
