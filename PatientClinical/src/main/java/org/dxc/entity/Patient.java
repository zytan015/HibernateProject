package org.dxc.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	@Id
	//@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column(nullable=false)
	private String firstName;
	
	@Column(nullable=false)
	private String lastname;
	
	@Column(nullable=false)
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cid")
	private List<ClinicalData> clinicalData;

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

	public List<ClinicalData> getClinicalData() {
		return clinicalData;
	}

	public void setClinicalData(List<ClinicalData> clinicalData) {
		this.clinicalData = clinicalData;
	}	
}
