package com.nrg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.TrackingData;
import com.nrg.services.AndriodDataService;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/Data")
public class AndriodServiceDataReceiver {
	
	@Autowired
	AndriodDataService andriodServiceData;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response saveAndroidServiceData(@RequestBody TrackingData data){
		Response response=null;
		try {
			response=andriodServiceData.saveAndroidServiceData(data);	
		} catch (Exception e) {
			response=new Response("fail",null,"");
		}
		
		return response;
		
	} 

}
