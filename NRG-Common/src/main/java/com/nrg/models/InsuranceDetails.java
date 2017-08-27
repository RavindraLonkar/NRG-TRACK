package com.nrg.models;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InsuranceDetails {

	private long insuranceid;
	private String vechiclename;
	private String vechiclenumber;
	private String insurancename;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",  timezone = "America/Phoenix")
	private Date startdate;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",  timezone = "America/Phoenix")
	private Date enddate;
	private Integer reminder;

	public InsuranceDetails() {
		super();
	}

	public InsuranceDetails(long insuranceid, String vechiclenumber, String vechiclename, String insurancename,
			Date startdate, Date enddate, Integer reminder) {
		super();
		this.insuranceid = insuranceid;
		this.vechiclenumber = vechiclenumber;
		this.vechiclename = vechiclename;
		this.insurancename = insurancename;
		this.startdate = startdate;
		this.enddate = enddate;
		this.reminder = reminder;
	}

	public long getInsuranceid() {
		return insuranceid;
	}

	public void setInsuranceid(long insuranceid) {
		this.insuranceid = insuranceid;
	}

	public String getVechiclename() {
		return vechiclename;
	}

	public void setVechiclename(String vechiclename) {
		this.vechiclename = vechiclename;
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
