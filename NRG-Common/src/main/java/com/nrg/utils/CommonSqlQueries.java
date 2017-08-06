package com.nrg.utils;

public class CommonSqlQueries {

	public static final String GET_VEHICLES = "select new com.nrg.models.VehicleDetails(v.vehicleid,v.user.userid,v.vechiclename,v.vechiclenumber) from Vechicle v where v.user.userid=:userid";
	
}
