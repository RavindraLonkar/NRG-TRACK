package com.nrg.services;

import java.util.List;

import com.nrg.models.User;
import com.nrg.models.Vechicle;
import com.nrg.models.VehicleDetails;

public interface VehicleService {

	List<VehicleDetails> getVehiclesOfUser(User user);
	
}
