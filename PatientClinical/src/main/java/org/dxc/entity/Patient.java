package org.dxc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient {
	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column(nullable=false)
	private String firstName;
	
	@Column(nullable=false)
	private String lastname;
	
	@Column(nullable=false)
	private int age;
	
	@OneToOne(mappedBy = "patient")
	private ClinicalData clinicalData;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ClinicalData getClinicalData() {
		return clinicalData;
	}

	public void setClinical(ClinicalData clinicalData) {
		this.clinicalData = clinicalData;
	}
	
	
}
