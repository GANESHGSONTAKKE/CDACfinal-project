package com.cdac.project.faculty.service;

import java.util.List;

import com.cdac.project.faculty.model.Applicant;

public interface ApplicantService {
	
	//Insert new applicant
	public Applicant addApplicant(Applicant applicant);
	
	//List all applicants (REST)
	public List<Applicant> listApplicants();
	
	//Count of applicants
	public Integer applicantCount();
	
}
