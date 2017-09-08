package com.nrg.datareceiver;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import com.nrg.models.DataPacket;
import com.nrg.models.LocationDataPacket;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUtils;

public class LocationDataPacketProcessor implements Callable<Boolean> {

	String dataPacket;
	public LocationDataPacketProcessor(String dataPacket) {
		this.dataPacket = dataPacket;
	}
	
	@Override
	public Boolean call() throws Exception {
		
		LocationDataPacket locationDataPacket = getLocationDataPacket(dataPacket);
		return null;
	}

	private LocationDataPacket getLocationDataPacket(String dataPacket) {
		
		LocationDataPacket locationDataPacket = new LocationDataPacket();
		
		DataPacket dataPacketData = new DataPacket();
		dataPacketData.setStartBit(CommonConstants.START_BYTE);
		dataPacketData.setPacketLength(dataPacket.substring(0,2));
		dataPacketData.setProtocolNumber(dataPacket.substring(2,4));
				
		locationDataPacket.setDateTime(CommonUtils.toTimestamp(new BigDecimal(CommonUtils.hex2Decimal(dataPacket.substring(4,16)))).toString());
		locationDataPacket.setGpsInfo(dataPacket.substring(16,18));
		locationDataPacket.setLatitude(dataPacket.substring(18,26));
		locationDataPacket.setLongitude(dataPacket.substring(26,34));
		locationDataPacket.setSpeed(dataPacket.substring(34,36));
		locationDataPacket.setCourseStatus(dataPacket.substring(36,40));
		locationDataPacket.setMcc(dataPacket.substring(40,44));
		locationDataPacket.setMnc(dataPacket.substring(44,46));
		locationDataPacket.setLocationCode(dataPacket.substring(46,50));
		locationDataPacket.setCellId(dataPacket.substring(50,56));
		
		dataPacketData.setInfoSerialNumber(dataPacket.substring(56,60));
		dataPacketData.setErrorCheck(dataPacket.substring(60,64));
		dataPacketData.setStopBit(dataPacket.substring(64,67));
		
		locationDataPacket.setDataPacket(dataPacketData);
				
		return null;
	}
		
}
