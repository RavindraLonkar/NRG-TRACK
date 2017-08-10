package com.nrg.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.User;
import com.nrg.models.Vechicle;
import com.nrg.models.VehiclePosition;
import com.nrg.repositories.TrackerRepository;
import com.nrg.repositories.TrackingDataRepository;
import com.nrg.repositories.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	TrackerRepository trackerRepository;

	@Autowired
	TrackingDataRepository trackingDataRepository;

	@Autowired
	private EntityManager entityManager;

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
		vehicle.setIsactive(1);
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
	public void deleteVehicles(List<Vechicle> vehicles) {		
		//TODO : for Hard Delete
		/*vehicleRepository.delete(vehicle);*/
		for(Vechicle vehicle : vehicles){
			Vechicle newVehicle = vehicleRepository.findVechicleByvehicleid(vehicle.getVehicleid());
			newVehicle.setIsactive(0);
			vehicleRepository.save(newVehicle);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehiclePosition> vehiclePositions(Integer userId) {
		final StoredProcedureQuery storedProcedureQuery = this.entityManager
				.createNamedStoredProcedureQuery("get_vehicleposition");
		storedProcedureQuery.setParameter("userid", userId);
		storedProcedureQuery.execute();
		return storedProcedureQuery.getResultList();
	}
}
