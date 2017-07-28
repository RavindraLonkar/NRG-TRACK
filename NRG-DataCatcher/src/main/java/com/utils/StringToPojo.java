package com.utils;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nrg.models.TrackingData;

@Component
public class StringToPojo {
	 public TrackingData toPojo(String str){
		 
			 Gson gson = new GsonBuilder().create();
			 TrackingData data = gson.fromJson(str, TrackingData.class);
		     return data;
	 }
}
