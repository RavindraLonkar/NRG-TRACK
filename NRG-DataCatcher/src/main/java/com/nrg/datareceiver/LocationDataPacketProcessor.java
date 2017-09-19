package com.nrg.datareceiver;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.nrg.datacatcher.utils.CommonUtils;
import com.nrg.datacatcher.utils.DataCatcherConstants;
import com.nrg.models.DataPacket;
import com.nrg.models.LocationDataPacket;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;


public class LocationDataPacketProcessor implements Callable<Boolean> {
	
	private static final Logger logger = Logger.getLogger(LocationDataPacketProcessor.class);
	
	Environment environment;
	
	String dataPacket;
	int port;
	public LocationDataPacketProcessor(String dataPacket, int port, Environment environment) {
		this.dataPacket = dataPacket;
		this.environment = environment;
		this.port = port;
	}
	
	@Override
	public Boolean call() throws Exception {
		
		LocationDataPacket locationDataPacket = getLocationDataPacket(dataPacket);
		saveLocationDataPacket(locationDataPacket);
		return null;
	}

	private LocationDataPacket getLocationDataPacket(String dataPacket) {
		
		LocationDataPacket locationDataPacket = new LocationDataPacket();
			
		DataPacket dataPacketData = new DataPacket();
		dataPacketData.setStartBit(DataCatcherConstants.START_BYTE);
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
		locationDataPacket.setDeviceId("355488020913415");
		
		dataPacketData.setInfoSerialNumber(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(56,60))));
		dataPacketData.setErrorCheck(Integer.toString(CommonUtils.hex2Decimal(dataPacket.substring(60,64))));
		dataPacketData.setStopBit(DataCatcherConstants.STOP_BYTE);
		dataPacketData.setPort(port);
		
		locationDataPacket.setDataPacket(dataPacketData);
		
		Gson gson = new Gson();
		String s = gson.toJson(locationDataPacket);
		System.out.println(s);
				
		return locationDataPacket;
	}
		
	private void saveLocationDataPacket(LocationDataPacket locationDataPacket) {
		Response response = null;
		try {

			RestTemplate restTemplate = new RestTemplate();
			String vehicleListUrl = environment.getProperty("SAVE_LOCATION_PACKET");
			restTemplate.postForObject(vehicleListUrl, locationDataPacket, Response.class);

		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
			logger.info("Error : " + response.toString());
		}
	}

}
