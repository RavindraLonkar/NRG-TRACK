package com.nrg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Tracker {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Id;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="vechicleId")
	private Vechicle vechicle;
	@Column
	private String deviceId;
	@Column
	private String trackerName;
	@Column
	private Integer CreatedBy;
	@Column
	private Date CreatedDate;
	@Column
	private Integer LastModifiedBy;
	@Column
	private Date LastModifiedDate;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Vechicle getVechicle() {
		return vechicle;
	}
	public void setVechicle(Vechicle vechicle) {
		this.vechicle = vechicle;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTrackerName() {
		return trackerName;
	}
	public void setTrackerName(String trackerName) {
		this.trackerName = trackerName;
	}
	public Integer getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(Integer createdBy) {
		CreatedBy = createdBy;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
	public Integer getLastModifiedBy() {
		return LastModifiedBy;
	}
	public void setLastModifiedBy(Integer lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return LastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
