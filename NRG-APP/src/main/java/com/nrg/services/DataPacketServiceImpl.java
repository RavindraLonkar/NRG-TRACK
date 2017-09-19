package com.nrg.services;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.LocationDataPacket;
import com.nrg.models.Tracker;
import com.nrg.models.TrackingData;
import com.nrg.repositories.DataPacketRepository;
import com.nrg.repositories.TrackerRepository;

@Service
public class DataPacketServiceImpl implements DataPacketService {

	@Autowired
	DataPacketRepository dataPacketRepository;
	private static final Logger logger = Logger.getLogger(DataPacketServiceImpl.class);

	@Autowired
	TrackerRepository trackerRepository;

	@Override
	public TrackingData saveLocationDataPacket(LocationDataPacket locationDataPacket) {

		Tracker tracker = new Tracker();
		tracker = trackerRepository.findByport(locationDataPacket.getDataPacket().getPort());

		// TODO : When process come by deviceId
		// tracker=dataPacketRepository.findBydeviceId(locationDataPacket.getDeviceId());

		TrackingData trackingData = new TrackingData();
		trackingData.setTracker(tracker);
		trackingData.setLatitude(locationDataPacket.getLatitude());
		trackingData.setLongitude(locationDataPacket.getLongitude());
		trackingData.setCreateddate(new Date());

		logger.info("PORT : " + locationDataPacket.getDataPacket().getPort());

		return dataPacketRepository.save(trackingData);
	}

}
