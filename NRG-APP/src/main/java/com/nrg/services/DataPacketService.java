package com.nrg.services;

import com.nrg.models.LocationDataPacket;
import com.nrg.models.TrackingData;

public interface DataPacketService {

	TrackingData saveLocationDataPacket(LocationDataPacket trackingData);

}
