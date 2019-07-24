package com.cdac.project.faculty.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cdac.project.faculty.model.Applicants;


@Component
@Service
public class ApplicantsDaoImpl implements ApplicantsDao{

	@PersistenceContext
    private EntityManager entityManager;
	
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Applicants addStudent(Applicants student) {
		this.sessionFactory = this.entityManager.unwrap(Session.class).getSessionFactory();
		Session session = this.sessionFactory.openSession();
		session.save(student);
		// TODO Auto-generated method stub
		return student;
	}


	
}
