package com.cdac.project.faculty.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name= "db_applicant")   
public class Applicant {

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer applicant_id;
	
	private String email;
	private String mobile;
	private String password;
	@DateTimeFormat(iso=ISO.DATE)
	private Date dob;
	private String name;
	private String gender;
	private String experience;
	private String qualifications;
	private String subject_interested;
	private String marital_status;
	private String languages_known;
	private String linkedin_link;
	private Integer document_id;
	private Date created_timestamp;
	private Date updated_timestamp;

	
	public Applicant() {
		
	}
	
	
	public Applicant(String email, String mobile, String password) {
		super();
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getMobile(){
		return mobile;
	}

	public void setMobile(String mobile){
		this.mobile=mobile;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public java.util.Date getDob(){
		return dob;
	}

	public void setDob(java.util.Date dob){
		this.dob=dob;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getGender(){
		return gender;
	}

	public void setGender(String gender){
		this.gender=gender;
	}

	public String getExperience(){
		return experience;
	}

	public void setExperience(String experience){
		this.experience=experience;
	}

	public String getQualifications(){
		return qualifications;
	}

	public void setQualifications(String qualifications){
		this.qualifications=qualifications;
	}

	public String getSubject_interested(){
		return subject_interested;
	}

	public void setSubject_interested(String subject_interested){
		this.subject_interested=subject_interested;
	}

	public String getMarital_status(){
		return marital_status;
	}

	public void setMarital_status(String marital_status){
		this.marital_status=marital_status;
	}

	public String getLanguages_known(){
		return languages_known;
	}

	public void setLanguages_known(String languages_known){
		this.languages_known=languages_known;
	}

	public String getLinkedin_link(){
		return linkedin_link;
	}

	public void setLinkedin_link(String linkedin_link){
		this.linkedin_link=linkedin_link;
	}

	public int getDocument_id(){
		return document_id;
	}

	public void setDocument_id(int document_id){
		this.document_id=document_id;
	}

	public java.util.Date getCreated_timestamp(){
		return created_timestamp;
	}

	public void setCreated_timestamp(java.util.Date created_timestamp){
		this.created_timestamp=created_timestamp;
	}

	public java.util.Date getUpdated_timestamp(){
		return updated_timestamp;
	}

	public void setUpdated_timestamp(java.util.Date updated_timestamp){
		this.updated_timestamp=updated_timestamp;
	}
	
	
}
