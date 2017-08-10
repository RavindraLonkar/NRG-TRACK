/**
 * 
 */
package com.nrg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.User;
import com.nrg.models.Vechicle;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

/**
 * @author Gourab
 *
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Value("${USER_SESSION_DATA}")
	private String USER_SESSION_DATA;

	@Value("${GET_VEHICLE_LIST}")
	private String GET_VEHICLE_LIST;
	
	@Value("${DELETE_VEHICLE}")
	private String DELETE_VEHICLE;
	
	@Value("${UPDATE_VEHICLE}")
	private String UPDATE_VEHICLE;
	
	@Value("${SAVE_VEHICLE}")
	private String SAVE_VEHICLE;
	
	@Value("${DELETE_VEHICLES}")
	private String DELETE_VEHICLES;
	
	@Value("${GET_TRACKING_DETAILS_BY_DATE}")
	private String GET_TRACKING_DETAILS_BY_DATE;
	
	@Value("${GET_VEHICLE_CURRENT_LOCATION_LIST}")
	private String GET_VEHICLE_CURRENT_LOCATION_LIST;
	
	@RequestMapping(value = "/track", method = RequestMethod.GET)
	public ModelAndView trackVehicle(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("VehicleTrack");
		return mv;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(HttpServletRequest request) {
		return new ModelAndView("vehicleRegistration");
	}

	@RequestMapping(value = "/trackingCoordinatesByDate", method = RequestMethod.GET)
	public Response trackingCoordinates(HttpServletRequest request) {
		Response response = null;
		RestTemplate restTemplate = new RestTemplate();
		
		Integer vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		
		String url = GET_TRACKING_DETAILS_BY_DATE + "?vehicleId=+"+vehicleId+"&startDate="+startDate+"&endDate="+endDate;
		response = restTemplate.getForObject(url, Response.class);
		
		return response;
	}

	@RequestMapping(value = "/vehicleReport", method = RequestMethod.GET)
	public ModelAndView vehicleReport(HttpServletRequest request) {

		return new ModelAndView("VehiclePosition");
	}

	@RequestMapping(value = "/vehiclePosition", method = RequestMethod.GET)
	public Response vehiclePosition(HttpServletRequest request) {

		// List<VehiclePosition> list=new ArrayList<VehiclePosition>();
		// list.add(new
		// VehiclePosition("MH12AS2112","22.890542","77.274856",1));

		Response res = new Response("success", null,
				"");
		return res;
	}
	
	//------------------------------------------------------	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getVehicleList(HttpServletRequest request) {

		Response response = null;
		try {
			User user = (User) request.getSession().getAttribute("usersession");

			RestTemplate restTemplate = new RestTemplate();
			String vehicleListUrl = GET_VEHICLE_LIST + "?userId=" + 1;
			response = restTemplate.getForObject(vehicleListUrl, Response.class);

		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}
	
	//------------------------------------------------------
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response addVehicle(@RequestBody Vechicle vehicle, HttpServletRequest request) {

		Response response = null;
		try {
			User user = (User) request.getSession().getAttribute("usersession");

			RestTemplate restTemplate = new RestTemplate();
			String vehicleListUrl = SAVE_VEHICLE + "?userId=" + 1;
			response = restTemplate.postForObject(vehicleListUrl, vehicle, Response.class);

		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}
	
	//------------------------------------------------------
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Response updateVehicle(@RequestBody Vechicle vehicle) {

		Response response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String vehicleListUrl = UPDATE_VEHICLE;
			response = restTemplate.postForObject(vehicleListUrl, vehicle, Response.class);
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
		return response;
	}
	
	//------------------------------------------------------	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Response deleteVehicle(@RequestBody List<Vechicle> vehicles) {

		Response response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String vehicleListUrl = DELETE_VEHICLES;
			response = restTemplate.postForObject(vehicleListUrl, vehicles, Response.class);
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
		return response;
	}
	//------------------------------------------------------	

	@RequestMapping(value = "/current/Position", method = RequestMethod.GET)
	public Response vehiclePositions(HttpServletRequest request) {
		Response response = null;
		try {
			User user = (User) request.getSession().getAttribute("usersession");
			RestTemplate restTemplate = new RestTemplate();
			String vehicleListUrl = GET_VEHICLE_CURRENT_LOCATION_LIST + "?userId=" + user.getUserid();
			response = restTemplate.getForObject(vehicleListUrl, Response.class);

		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

}
