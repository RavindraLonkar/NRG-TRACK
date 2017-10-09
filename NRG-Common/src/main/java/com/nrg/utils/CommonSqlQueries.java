package com.nrg.utils;

public class CommonSqlQueries {

	public static final String GET_VEHICLES = "select new com.nrg.models.VehicleDetails(v.vehicleid,v.user.userid,v.vechiclename,v.vechiclenumber) from Vechicle v where v.user.userid=:userid and isactive = 1";
	public static final String GET_TRACKER_VEHICLES = "select new com.nrg.models.VehicleDetails(v.vehicleid,v.user.userid,v.vechiclename,v.vechiclenumber) from Tracker t inner join t.vechicle v where v.user.userid=:userid and v.isactive = 1";
	public static final String GET_VEHICLES_POSITION_BY_DATE = "select new com.nrg.models.VehicleDatePosition(t.tracker.vechicle.vechiclenumber,t.tracker.vechicle.vechiclename,t.latitude,t.longitude) from TrackingData t where t.tracker.vechicle.vehicleid = :vehicleId and t.createddate > :trackdate order by createddate asc";
	public static final String GET_INSURANCES = "select new com.nrg.models.InsuranceDetails(insurance.insuranceid,insurance.vehicle.vechiclenumber,insurance.vehicle.vechiclename, insurance.insurancename, insurance.startdate, insurance.enddate, insurance.reminder,CASE WHEN DATE_PART('day', insurance.enddate - now()) >0 THEN '1' else '0' END) from Insurance insurance where insurance.vehicle.user.userid=:userid and insurance.isactive=1 and insurance.vehicle.isactive=1";
}
