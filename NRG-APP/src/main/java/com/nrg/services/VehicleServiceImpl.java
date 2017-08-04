package com.nrg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.VehicleDetails;
import com.nrg.repositories.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public List<VehicleDetails> getVehiclesOfUser(Integer userId) {
		return vehicleRepository.findByUserId(userId);
	}

}
