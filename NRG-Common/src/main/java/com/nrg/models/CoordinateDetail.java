package com.nrg.models;

public class CoordinateDetail {
  
   private String vehicleNo;
   private String date;
   private String longitude;
   private String latitude;
 
public CoordinateDetail() {
super();
}
public String getLongitude() {
	return longitude;
}

public CoordinateDetail(String vehicleNo, String longitude, String latitude) {
	super();
	this.vehicleNo = vehicleNo;
	this.longitude = longitude;
	this.latitude = latitude;
}
public void setLongitude(String longitude) {
	this.longitude = longitude;
}
public String getLatitude() {
	return latitude;
}
public void setLatitude(String latitude) {
	this.latitude = latitude;
}

public String getVehicleNo() {
	return vehicleNo;
}
public void setVehicleNo(String vehicleNo) {
	this.vehicleNo = vehicleNo;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
@Override
public String toString() {
	return "CoordinateDetails [longitude=" + longitude + ", latitude=" + latitude + "]";
}
   
}
