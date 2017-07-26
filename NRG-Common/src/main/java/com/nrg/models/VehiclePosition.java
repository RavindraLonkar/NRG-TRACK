package com.nrg.models;

public class VehiclePosition {

	private String vehicleNumber;
	private String longitude;
	private String latitude;
	private int index;
	
	public VehiclePosition() {
		super();
	}

	public VehiclePosition(String vehicleNumber, String longitude, String latitude, int index) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.longitude = longitude;
		this.latitude = latitude;
		this.index = index;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "VehiclePosition [vehicleNumber=" + vehicleNumber + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", index=" + index + "]";
	}
	
	
}
