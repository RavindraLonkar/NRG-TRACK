package com.nrg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TXN_TrackingData")
public class TrackingData {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Id;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="trackerId")
	private Tracker tracker;
	
	@Column
	private String latitude;
	@Column
	private String longitude;
	@Column
	private String createdDate;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Tracker getTracker() {
		return tracker;
	}
	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
