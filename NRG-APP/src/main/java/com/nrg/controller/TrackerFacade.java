package com.nrg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.CoordinateDetail;
import com.nrg.models.Tracker;
import com.nrg.models.TrackingData;
import com.nrg.services.TrackerService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/tracker")
public class TrackerFacade {
	@Autowired
	TrackerService trackerService;

	@RequestMapping(value = "/trackingData", method = RequestMethod.GET)
	public List<CoordinateDetail> getTrackingData(HttpServletRequest request) {
		Response response = null;
		List<CoordinateDetail> list=new ArrayList<CoordinateDetail>();
		try{
			//String userid = request.getParameter("userId");
			//User user=new User();
			//user.setUserid( Long.parseLong(userid, 10)  );
			 Tracker tracker=new Tracker();
			 tracker.setTrackerid(1);
			 list = trackerService.getTrackingData(tracker);
			
			if (list.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			}else{
				response = new Response(CommonConstants.NRG_SCUCESS, list, null);
			}
		}catch(Exception e){
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
				
		return list;
	}
	
	@RequestMapping(value = "/LatestList", method = RequestMethod.GET)
	public List<TrackingData> findLatestPosition(HttpServletRequest request) {
		Response response = null;
		List<TrackingData> list=new ArrayList<TrackingData>();
		try{
			//String userid = request.getParameter("userId");
			//User user=new User();
			//user.setUserid( Long.parseLong(userid, 10)  );
			 Tracker tracker=new Tracker();
			 tracker.setTrackerid(1);
			 list = trackerService.findLatestPosition(1);
			
			if (list.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			}else{
				response = new Response(CommonConstants.NRG_SCUCESS, list, null);
			}
		}catch(Exception e){
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
				
		return list;
	}
}
