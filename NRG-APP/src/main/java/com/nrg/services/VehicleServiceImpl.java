package com.nrg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.User;
import com.nrg.models.Vechicle;
import com.nrg.repositories.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public List<Vechicle> getVehiclesList(Integer userId) {	
		User user = new User();
		user.setUserid(userId);
		
		return vehicleRepository.findByUserId(userId);
	}
	
	@Override
	public Vechicle addVehicle(Vechicle vehicle, Integer userid) {
		User user = new User();
		user.setUserid(userid);
		vehicle.setUser(user);
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vechicle updateVehicle(Vechicle vehicle) {
		Vechicle newVehicle = vehicleRepository.findVechicleByvehicleid(vehicle.getVehicleid());
		newVehicle.setVechiclename(vehicle.getVechiclename());
		newVehicle.setVechiclenumber(vehicle.getVechiclenumber());
		newVehicle.setVechiclename(vehicle.getVechiclename());
		return vehicleRepository.save(newVehicle);
	}

	@Override
	public void deleteVehicle(Vechicle vehicle) {		
		vehicleRepository.delete(vehicle);
	}

	@Override
	public void deleteMultipleVehicle(String vehicleIdsString) {
		String vehicleIds[] = vehicleIdsString.split(",");
		for(String vehicleId : vehicleIds){
			vehicleRepository.delete((long) Integer.parseInt(vehicleId));
		}
		
	}
}
