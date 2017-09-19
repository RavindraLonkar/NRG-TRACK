package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nrg.models.Tracker;
import com.nrg.models.TrackingData;

@Repository
public interface DataPacketRepository extends CrudRepository<TrackingData, Long> {

	
}