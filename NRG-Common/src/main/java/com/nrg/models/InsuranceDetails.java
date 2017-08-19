package com.nrg.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InsuranceDetails {
	
	private String vechiclenumber;
	private String insurancename;
	@Column
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date startdate;
	@Column
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date enddate;
	private Integer reminder;
	
	public InsuranceDetails() {
		super();
	}

	public InsuranceDetails(String vechiclenumber, String insurancename, Date startdate, Date enddate, Integer reminder) {
		super();
		this.vechiclenumber = vechiclenumber;
		this.insurancename = insurancename;
		this.startdate = startdate;
		this.enddate = enddate;
		this.reminder = reminder;
	}
	public String getVechiclenumber() {
		return vechiclenumber;
	}
	public void setVechiclenumber(String vechiclenumber) {
		this.vechiclenumber = vechiclenumber;
	}
	public String getInsurancename() {
		return insurancename;
	}
	public void setInsurancename(String insurancename) {
		this.insurancename = insurancename;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Integer getReminder() {
		return reminder;
	}
	public void setReminder(Integer reminder) {
		this.reminder = reminder;
	}

}
