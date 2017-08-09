package com.nrg.models;

public class VehicleDetails {

	private Integer vehicleid;
	private Integer userid;
	private String vechiclename;
	private String vechiclenumber;

	public VehicleDetails() {
		super();
	}

	public VehicleDetails(Integer vehicleid, Integer userid, String vechiclename, String vechiclenumber) {
		super();
		this.vehicleid = vehicleid;
		this.userid = userid;
		this.vechiclename = vechiclename;
		this.vechiclenumber = vechiclenumber;
	}

	public Integer getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(Integer vehicleid) {
		this.vehicleid = vehicleid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getVechiclename() {
		return vechiclename;
	}

	public void setVechiclename(String vechiclename) {
		this.vechiclename = vechiclename;
	}

	public String getVechiclenumber() {
		return vechiclenumber;
	}

	public void setVechiclenumber(String vechiclenumber) {
		this.vechiclenumber = vechiclenumber;
	}


}
