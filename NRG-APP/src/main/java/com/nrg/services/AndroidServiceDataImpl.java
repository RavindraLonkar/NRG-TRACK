package com.nrg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.TrackingData;
import com.nrg.repositories.AndroidServiceDataRepository;
import com.nrg.utils.Response;

@Service
public class AndroidServiceDataImpl implements AndriodServiceData {

	@Autowired
	AndroidServiceDataRepository androidServiceDataRepository;
	
	@Override
	public Response saveAndroidServiceData(TrackingData data) {
		Response response=null;
		TrackingData reponseData= androidServiceDataRepository.save(data);
		response=new Response("sucess",reponseData,"");
		return response;
	}

}
