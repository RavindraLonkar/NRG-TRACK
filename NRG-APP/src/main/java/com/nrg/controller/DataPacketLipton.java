package com.nrg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.LocationDataPacket;
import com.nrg.models.User;
import com.nrg.services.DataPacketService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/datapacket")
public class DataPacketLipton {
	
	@Autowired
	DataPacketService dataPacketService;
	
	
	@RequestMapping(value = "/location/save", method = RequestMethod.POST)
	public Response saveLocationDataPacket(@RequestBody LocationDataPacket locationDataPacket) {
		LocationDataPacket createdLocationDataPacket = null;
		createdLocationDataPacket = dataPacketService.saveLocationDataPacket(locationDataPacket);
		if (createdLocationDataPacket != null) {
			return new Response(CommonConstants.NRG_SCUCESS, createdLocationDataPacket, null);
		} else {
			return new Response(CommonConstants.NRG_FAIL, null, null);
		}
	}
}
