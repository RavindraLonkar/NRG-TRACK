package com.nrg.datareceiver;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import com.google.gson.Gson;
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
		locationDataPacket.setGpsInfo(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(16,18))));
		locationDataPacket.setLatitude(Double.toString(CommonUtils.hexToLatLong(dataPacket.substring(18,26))));
		locationDataPacket.setLongitude(Double.toString(CommonUtils.hexToLatLong(dataPacket.substring(26,34))));
		locationDataPacket.setSpeed(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(34,36))));
		locationDataPacket.setCourseStatus(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(36,40))));
		locationDataPacket.setMcc(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(40,44))));
		locationDataPacket.setMnc(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(44,46))));
		locationDataPacket.setLocationCode(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(46,50))));
		locationDataPacket.setCellId(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(50,56))));
		
		dataPacketData.setInfoSerialNumber(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(56,60))));
		dataPacketData.setErrorCheck(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(60,64))));
		dataPacketData.setStopBit(CommonConstants.STOP_BYTE);
		
		locationDataPacket.setDataPacket(dataPacketData);
		
		Gson gson = new Gson();
		String s = gson.toJson(locationDataPacket);
		System.out.println(s);
				
		return null;
	}
		
}
