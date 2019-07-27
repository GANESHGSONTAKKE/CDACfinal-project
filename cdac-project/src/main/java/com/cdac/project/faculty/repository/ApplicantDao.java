package com.cdac.project.faculty.repository;



import java.util.List;

import com.cdac.project.faculty.model.Applicant;

public interface ApplicantDao {

	//Insert new applicant
	public Applicant addApplicant(Applicant applicant);
	
	//List all applicants (REST)
		public List<Applicant> listApplicants();
}
