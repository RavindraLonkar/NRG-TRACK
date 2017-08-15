package com.nrg.utils;

public class CommonSqlQueries {

	public static final String GET_VEHICLES = "select new com.nrg.models.VehicleDetails(v.vehicleid,v.user.userid,v.vechiclename,v.vechiclenumber) from Vechicle v where v.user.userid=:userid and isactive = 1";
	public static final String GET_TRACKER_VEHICLES = "select new com.nrg.models.VehicleDetails(v.vehicleid,v.user.userid,v.vechiclename,v.vechiclenumber) from Tracker t inner join t.vechicle v where v.user.userid=:userid and v.isactive = 1";
	
}
