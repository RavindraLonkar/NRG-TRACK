package com.nrg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.Tracker;
import com.nrg.models.TrackingData;
import com.nrg.repositories.TrackingDataRepository;

@Service
public class TrackerServiceImpl implements TrackerService {
	
	@Autowired
	TrackingDataRepository trackingDataRepository;

	@Override
	public List<TrackingData> getTrackingData(Tracker tracker) {
		Date d1=null;
		Date d2=null;
		//return trackingDataRepository.findAllByTracker(tracker);
		String date_s = " 2011-01-18 00:00:00.0"; 
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd HH:mm:ss"); 
		try {
			 d1 = dt.parse("2017-07-30 12:05:17");
			 d2 = dt.parse("2017-07-30 17:05:17");
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		List<TrackingData>  s=trackingDataRepository.findBytrackingdataid(1);//("2017-07-30 12:05:17","2017-07-30 17:05:17");
		
		return null;
	}
	

}
