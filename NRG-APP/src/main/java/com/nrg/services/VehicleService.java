package com.nrg.services;

import java.util.List;

import com.nrg.models.Vechicle;

public interface VehicleService {

	List<Vechicle> getVehiclesList(Integer userId);
	
	Vechicle updateVehicle(Vechicle vehicle);

	void deleteVehicle(Vechicle vehicle);

	Vechicle addVehicle(Vechicle vehicle, Integer userid);

	void deleteVehicles(List<Vechicle> vehicles);
	
}
