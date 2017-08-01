package com.nrg.models;

public class VehicleDetails {

	private Integer vehicleid;
	private long userid;
	private String vechiclename;
	private String vechiclenumber;
	
	
	public VehicleDetails() {
		super();
	}


	public VehicleDetails(Integer vehicleid, long userid, String vechiclename, String vechiclenumber) {
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


	public long getUserid() {
		return userid;
	}


	public void setUserid(long userid) {
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


	@Override
	public String toString() {
		return "VehicleDetails [vehicleid=" + vehicleid + ", userid=" + userid + ", vechiclename=" + vechiclename
				+ ", vechiclenumber=" + vechiclenumber + "]";
	}
	
	
}
