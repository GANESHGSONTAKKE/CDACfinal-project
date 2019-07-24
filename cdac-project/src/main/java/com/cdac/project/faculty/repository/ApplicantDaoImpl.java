package com.cdac.project.faculty.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cdac.project.faculty.model.Applicant;


@Repository
public class ApplicantDaoImpl implements ApplicantDao{

	@PersistenceContext
    private EntityManager entityManager;
	
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Applicant addApplicant(Applicant applicant) {
		this.sessionFactory = this.entityManager.unwrap(Session.class).getSessionFactory();
		Session session = this.sessionFactory.openSession();
		session.save(applicant);
		return applicant;
	}


	
}
