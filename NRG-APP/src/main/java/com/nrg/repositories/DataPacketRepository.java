package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nrg.models.LocationDataPacket;

@Repository
public interface DataPacketRepository extends CrudRepository<LocationDataPacket, Long> {

	
}