package com.nrg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mst_tracker")
public class Tracker {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer trackerid;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicleid")
	private Vechicle vechicle;
	@Column
	private String deviceid;
	@Column
	private String trackername;
	@Column
	private Integer Createdby;
	@Column
	private Date Createddate;
	@Column
	private Integer LastModifiedby;
	@Column
	private Date LastModifieddate;

	public Integer getTrackerid() {
		return trackerid;
	}

	public void setTrackerid(Integer trackerid) {
		this.trackerid = trackerid;
	}

	public Vechicle getVechicle() {
		return vechicle;
	}

	public void setVechicle(Vechicle vechicle) {
		this.vechicle = vechicle;
	}


	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getTrackername() {
		return trackername;
	}

	public void setTrackername(String trackername) {
		this.trackername = trackername;
	}

	public Integer getCreatedby() {
		return Createdby;
	}

	public void setCreatedby(Integer createdby) {
		Createdby = createdby;
	}

	public Date getCreateddate() {
		return Createddate;
	}

	public void setCreateddate(Date createddate) {
		Createddate = createddate;
	}

	public Integer getLastModifiedby() {
		return LastModifiedby;
	}

	public void setLastModifiedby(Integer lastModifiedby) {
		LastModifiedby = lastModifiedby;
	}

	public Date getLastModifieddate() {
		return LastModifieddate;
	}

	public void setLastModifieddate(Date lastModifieddate) {
		LastModifieddate = lastModifieddate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
