package com.nrg.models;

import javax.persistence.Column;

public class CoordinateDetail {
  
   private Integer trackerid;
   private Integer trackingdataid;
   private String latitude;
   private String longitude;
	
   public CoordinateDetail() {
		super();
	}

public CoordinateDetail(Integer trackerid, Integer trackingdataid, String latitude, String longitude) {
	super();
	this.trackerid = trackerid;
	this.trackingdataid = trackingdataid;
	this.latitude = latitude;
	this.longitude = longitude;
}

public Integer getTrackerid() {
	return trackerid;
}

public void setTrackerid(Integer trackerid) {
	this.trackerid = trackerid;
}

public Integer getTrackingdataid() {
	return trackingdataid;
}

public void setTrackingdataid(Integer trackingdataid) {
	this.trackingdataid = trackingdataid;
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

@Override
public String toString() {
	return "CoordinateDetail [trackerid=" + trackerid + ", trackingdataid=" + trackingdataid + ", latitude=" + latitude
			+ ", longitude=" + longitude + "]";
}
   
  
   
}
