package com.nrg.services;

import java.util.List;

import com.nrg.models.CoordinateDetail;
import com.nrg.models.VehiclePosition;

public interface TrackerService {

	List<CoordinateDetail> getTrackingData(Integer vehicleId,String startDate,String endDate);
	List<VehiclePosition> findVehiclePositionByDate(Integer vehicleId,String trackDate);
}
