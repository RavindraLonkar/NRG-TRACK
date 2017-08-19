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

@Entity
@Table(name = "TXN_Insurance")
public class Insurance {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long insuranceid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicleid")
	private Vechicle vehicle;
	
	private String insurancename;
	@Column
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date startdate;
	@Column
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date enddate;
	private Integer reminder;
	private Integer isactive;
	private Integer createdby;
	private Date createddate;
	private Integer lastmodifiedby;
	private Date lastmodifieddate;
	public long getInsuranceid() {
		return insuranceid;
	}
	public void setInsuranceid(long insuranceid) {
		this.insuranceid = insuranceid;
	}
	public Vechicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vechicle vehicle) {
		this.vehicle = vehicle;
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
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public Integer getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Integer getLastmodifiedby() {
		return lastmodifiedby;
	}
	public void setLastmodifiedby(Integer lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}
	public Date getLastmodifieddate() {
		return lastmodifieddate;
	}
	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
