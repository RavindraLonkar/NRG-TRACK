package com.nrg.models;

public class LocationDataPacket {
	private DataPacket dataPacket;
	private String dateTime;
	private String gpsInfo;
	private String latitude;
	private String longitude;
	private String speed;
	private String courseStatus;
	private String mcc;
	private String mnc;
	private String locationCode;
	private String cellId;
	public DataPacket getDataPacket() {
		return dataPacket;
	}
	public void setDataPacket(DataPacket dataPacket) {
		this.dataPacket = dataPacket;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getGpsInfo() {
		return gpsInfo;
	}
	public void setGpsInfo(String gpsInfo) {
		this.gpsInfo = gpsInfo;
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
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getMnc() {
		return mnc;
	}
	public void setMnc(String mnc) {
		this.mnc = mnc;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	
}
