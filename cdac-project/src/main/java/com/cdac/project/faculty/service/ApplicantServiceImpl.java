package com.cdac.project.faculty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.project.faculty.model.Applicant;
import com.cdac.project.faculty.repository.ApplicantDao;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantDao applicantDao; 
	
	@Override
	public Applicant addApplicant(Applicant applicant) {
		return applicantDao.addApplicant(applicant);
	}

	@Override
	public List<Applicant> listApplicants() {
		return applicantDao.listApplicants();
	}

}
