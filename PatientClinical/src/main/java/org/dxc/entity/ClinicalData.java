package org.dxc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClinicalData {
	@Id
	@Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	@Column(nullable=false)
	private String componentName;
	
	@Column(nullable=false)
	private int componentValue;
	
	@Column(nullable=false)
	private String measuredDateTime;  
//	
//	@ManyToOne
//	@JoinColumn(name="cid", nullable=false)
//	private Patient patient;
//	
//	public ClinicalData(String componentName, int componentValue, String measuredDateTime, Patient p) {
//		this.componentName = componentName;
//		this.measuredDateTime = measuredDateTime;
//		this.patient = p;
//	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public int getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(int componentValue) {
		this.componentValue = componentValue;
	}

	public String getMeasuredDateTime() {
		return measuredDateTime;
	}

	public void setMeasuredDateTime(String strDate) {
		this.measuredDateTime = strDate;
	}

}
