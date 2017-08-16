package com.nrg.models;

public class VehicleDatePosition {

	public VehicleDatePosition() {
		super();
	}

	public VehicleDatePosition(String vehiclenumber, String vehiclename, String latitude, String longitude) {
		super();
		this.vehiclenumber = vehiclenumber;
		this.vehiclename = vehiclename;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	private String vehiclenumber;
	private String vehiclename;
	private String longitude;
	private String latitude;

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	public String getLongitude() {
		return longitude;
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

}
