package com.nrg.services;

import java.util.List;

import com.nrg.models.Vechicle;

public interface VehicleService {

	List<Vechicle> getVehiclesOfUser(Integer userid);
	
}
