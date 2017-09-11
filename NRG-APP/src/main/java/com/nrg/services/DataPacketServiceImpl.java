package com.nrg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.LocationDataPacket;
import com.nrg.repositories.DataPacketRepository;

@Service
public class DataPacketServiceImpl implements DataPacketService {
	
	@Autowired
	DataPacketRepository dataPacketRepository;

	@Override
	public LocationDataPacket saveLocationDataPacket(LocationDataPacket locationDataPacket) {		
		return dataPacketRepository.save(locationDataPacket);		
	}
		
}
