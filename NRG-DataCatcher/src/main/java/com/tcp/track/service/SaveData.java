package com.tcp.track.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nrg.models.TrackingData;
import com.nrg.utils.Response;
import com.utils.StringToPojo;

@Service
public class SaveData {
	@Autowired
	private StringToPojo stringToPojo;
	
	@Value("${SAVE_ANDROID_SERVICEDATA}")
	private String SAVE_ANDROID_SERVICEDATA;
	
	public void saveDetails(String str){
		
		TrackingData trackingData=stringToPojo.toPojo(str);
		
		String url=SAVE_ANDROID_SERVICEDATA;
		RestTemplate rs=new RestTemplate();
		rs.postForObject(url, trackingData, Response.class);
		
	}
}
