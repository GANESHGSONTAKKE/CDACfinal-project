package com.cdac.project.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.project.faculty.model.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

}
