package com.nrg.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.LocationDataPacket;
import com.nrg.models.Tracker;
import com.nrg.models.TrackingData;
import com.nrg.repositories.DataPacketRepository;

@Service
public class DataPacketServiceImpl implements DataPacketService {
	
	@Autowired
	DataPacketRepository dataPacketRepository;

	@Override
	public TrackingData saveLocationDataPacket(LocationDataPacket locationDataPacket) {	
						
		Tracker tracker = new Tracker();
		tracker.setDeviceid(locationDataPacket.getDeviceId());
		
		TrackingData trackingData = new TrackingData();
		trackingData.setTracker(tracker);
		trackingData.setLatitude(locationDataPacket.getLatitude());
		trackingData.setLongitude(locationDataPacket.getLongitude());
		trackingData.setCreateddate(new Date());		
						
		return dataPacketRepository.save(trackingData);
	}
		
}
