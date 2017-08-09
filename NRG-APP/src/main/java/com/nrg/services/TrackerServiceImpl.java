package com.nrg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.CoordinateDetail;
import com.nrg.models.Tracker;
import com.nrg.models.TrackingData;
import com.nrg.repositories.TrackingDataRepository;

@Service
public class TrackerServiceImpl implements TrackerService {
	
	@Autowired
	TrackingDataRepository trackingDataRepository;

	@Override
	public List<CoordinateDetail> getTrackingData(Integer vehicleId,String startDate,String endDate) {
		Date d1=null;
		Date d2=null;
		//return trackingDataRepository.findAllByTracker(tracker);
		String date_s = " 2011-01-18 00:00:00.0"; 
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		try {
			 d1 = (Date)dt.parse("2017-07-30 11:05:17");
			 d2 = (Date)dt.parse("2017-07-30 17:05:17");
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		List<CoordinateDetail>  list=trackingDataRepository.findBytrackerId(vehicleId,d1,d2);
		
		return list;
	}

	@Override
	public List<TrackingData> findLatestPosition(Integer userid) {
		
		List<TrackingData> list=findLatestPosition(userid);
		
		return null;
	}
	

}
