package com.nrg.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@NamedStoredProcedureQuery(name = "get_vehicleposition", procedureName = "get_vehicleposition", resultClasses = VehiclePosition.class, parameters = {
		 @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "userid")
})
@Entity
@Table(name="Temp_VehiclePosition")
public class VehiclePosition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehiclepositionid;
	
	private String vehiclenumber;
	private String vehiclename;
	private String longitude;
	private String latitude;

	
	
	public Integer getVehiclepositionid() {
		return vehiclepositionid;
	}

	public void setVehiclepositionid(Integer vehiclepositionid) {
		this.vehiclepositionid = vehiclepositionid;
	}

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
