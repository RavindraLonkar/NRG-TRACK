package com.nrg.services;

import java.util.List;

import com.nrg.models.VehicleDetails;

public interface VehicleService {

	List<VehicleDetails> getVehiclesOfUser(Integer userId);
	
}
