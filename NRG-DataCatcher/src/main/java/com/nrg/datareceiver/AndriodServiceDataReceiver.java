package com.nrg.datareceiver;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nrg.models.TrackingData;
import com.nrg.utils.Response;

@RestController
@RequestMapping("api/V1/dataReceiver/")
public class AndriodServiceDataReceiver {
	
	@Value("${SAVE_ANDROID_SERVICEDATA}")
	private String SAVE_ANDROID_SERVICEDATA;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response saveAndroidServiceData(@RequestBody TrackingData trackingData){
		Date date = new Date();
		trackingData.setCreateddate(date);
		Response response = null;
		
		String url=SAVE_ANDROID_SERVICEDATA;
		RestTemplate rs=new RestTemplate();
		response=rs.postForObject(url, trackingData, Response.class);
		return response;
	}
}
