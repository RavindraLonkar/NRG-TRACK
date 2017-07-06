package com.nrg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.Tracker;
import com.nrg.models.TrackingData;
import com.nrg.repositories.AndroidServiceDataRepository;
import com.nrg.repositories.TrackerRepository;
import com.nrg.utils.Response;

@Service
public class AndroidDataServiceImpl implements AndriodDataService {

	@Autowired
	AndroidServiceDataRepository androidServiceDataRepository;
	
	@Autowired
	TrackerRepository trackerRepository;
	
	@Override
	public Response saveAndroidServiceData(TrackingData data) {
		Response response=null;
		Tracker trackerData=new Tracker();
		trackerData=trackerRepository.findBydeviceid(data.getTdeviceid());
		if(trackerData!=null){
			data.setTracker(trackerData);;
		}else{
			response=new Response("fail",null,"Need to register device first.");
		}
		TrackingData reponseData= androidServiceDataRepository.save(data);
		response=new Response("sucess",reponseData,"");
		return response;
	}

}
