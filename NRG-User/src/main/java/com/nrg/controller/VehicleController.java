/**
 * 
 */
package com.nrg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.CoordinateDetail;
import com.nrg.models.User;
import com.nrg.models.VehicleDetails;
import com.nrg.models.VehiclePosition;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

/**
 * @author Gourab
 *
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	@Value("${USER_SESSION_DATA}")
	private String USER_SESSION_DATA;
	
	@Value("${GET_VEHICLE_LIST}")
	private String GET_VEHICLE_LIST;

	@RequestMapping(value = "/tracks", method = RequestMethod.GET)
	public ModelAndView trackVehicle(HttpServletRequest request) {				
		 
		RestTemplate restTemplate = new RestTemplate();
		//String url = GET_VEHICLE_LIST + "?userId=" + "1";
		//Response result = restTemplate.getForObject(url, Response.class);
		List<VehicleDetails> vehicle=new ArrayList<>(); 
		vehicle.add(new VehicleDetails(1,1,"aaaa","aaaa1111"));
		vehicle.add(new VehicleDetails(2,1,"bbbb","bbbb1111"));
		vehicle.add(new VehicleDetails(3,1,"cccc","cccc1111"));
		
		ModelAndView mv=new ModelAndView("VehicleTrack");
		mv.addObject("vlist", vehicle);
		return mv;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(HttpServletRequest request) {				
		return new ModelAndView("vehicleRegistration");
	}
	
	@RequestMapping(value = "/trackingCoordinates", method = RequestMethod.GET)
	public Response trackingCoordinates(HttpServletRequest request) {
		
		Integer vehicle=Integer.parseInt(request.getParameter("vehicleId"));
		List<CoordinateDetail> list=new ArrayList<CoordinateDetail>();
		list.add(new CoordinateDetail(1,1,"21.486934","86.924600"));
		list.add(new CoordinateDetail(1,2,"28.704059","77.102490"));
		//list.add(new CoordinateDetail("1234","28.704059","77.102490"));
		//list.add(new CoordinateDetail("1234","28.734059","78.102490"));
		//list.add(new CoordinateDetail("1234","28.454405","78.102490"));
		//list.add(new CoordinateDetail("1234","66.704059","77.102490"));
		list.add(new CoordinateDetail(1,3,"21.145800","79.088155"));
		list.add(new CoordinateDetail(1,4,"18.520430","73.856744"));
		
		Response res=new Response("success",list,"");
		return res;
	}
	
	@RequestMapping(value = "/vehicleReport", method = RequestMethod.GET)
	public ModelAndView vehicleReport(HttpServletRequest request) {
				
		return new ModelAndView("VehiclePosition");
	}
	
	@RequestMapping(value = "/vehiclePosition", method = RequestMethod.GET)
	public Response vehiclePosition(HttpServletRequest request) {
		
		//List<VehiclePosition> list=new ArrayList<VehiclePosition>(); 
		//list.add(new VehiclePosition("MH12AS2112","22.890542","77.274856",1));
		
		Response res=new Response("success",new VehiclePosition("MH12AS2112","22.890542","77.274856",1),"");
		return res;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getVehicleList(HttpServletRequest request) {
		
		Response response = null;
		try {			
			User user = (User) request.getSession().getAttribute("usersession");
			
			RestTemplate restTemplate = new RestTemplate();
			String vehicleListUrl = GET_VEHICLE_LIST + "?userId=" + "1";
			response = restTemplate.getForObject(vehicleListUrl, Response.class);
			
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}
}
