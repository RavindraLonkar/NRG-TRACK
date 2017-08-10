package com.nrg.services;

import java.util.List;

import com.nrg.models.Vechicle;
import com.nrg.models.VehiclePosition;

public interface VehicleService {

	List<Vechicle> getVehiclesList(Integer userId);

	Vechicle updateVehicle(Vechicle vehicle);

	Vechicle addVehicle(Vechicle vehicle, Integer userid);

	List<VehiclePosition> vehiclePositions(Integer userId);

	void deleteVehicles(List<Vechicle> vehicles);

}
