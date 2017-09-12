package com.nrg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TXN_Trackingdata")
public class TrackingData {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trackingdataid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trackerid")
	private Tracker tracker;

	@Column
	private String latitude;
	@Column
	private String longitude;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss",  timezone = "America/Phoenix")
	private Date createddate;
	@Column
	private String tdeviceid;
	@Column
	private Integer speed;

	public Integer getTrackingdataid() {
		return trackingdataid;
	}

	public void setTrackingdataid(Integer trackingdataid) {
		this.trackingdataid = trackingdataid;
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

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getTdeviceid() {
		return tdeviceid;
	}

	public void setTdeviceid(String tdeviceid) {
		this.tdeviceid = tdeviceid;
	}
	
	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
