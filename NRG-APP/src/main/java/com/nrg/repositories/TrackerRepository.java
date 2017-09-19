package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nrg.models.Tracker;

public interface TrackerRepository extends CrudRepository<Tracker, Integer> {

	Tracker findBydeviceid(String deviceid);
	
	//TODO : Remove When device id base process come
	Tracker findByport(Integer port);

}
