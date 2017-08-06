package com.nrg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.User;
import com.nrg.models.Vechicle;
import com.nrg.services.VehicleService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/vehicle")
public class VehicleLipton {
	@Autowired
	VehicleService vehicleService;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getVehiclesOfUser(HttpServletRequest request) {
		Response response = null;
		try{
			String userid = request.getParameter("userId");
			User user=new User();
			//user.setUserid( Long.parseLong(userid, 1)  );
			List<Vechicle> vehicle = vehicleService.getVehiclesList(Integer.parseInt(userid));
			
			if (vehicle.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			}else{
				response = new Response(CommonConstants.NRG_SCUCESS, vehicle, null);
			}
		}catch(Exception e){
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
				
		return response;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response addVehicle(@RequestBody Vechicle vehicle, HttpServletRequest request) {
		Response response = null;
		try{
			String userid = request.getParameter("userId");			
			Vechicle addedVehicle = vehicleService.addVehicle(vehicle,Integer.parseInt(userid));
			
			if (addedVehicle == null) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			}else{
				response = new Response(CommonConstants.NRG_SCUCESS, addedVehicle, null);
			}
		}catch(Exception e){
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
				
		return response;
	}
		
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Response updateVehicle(@RequestBody Vechicle vehicle, HttpServletRequest request) {
		Response response = null;
		try{
			Vechicle updatedVehicle = vehicleService.updateVehicle(vehicle);
			
			if (updatedVehicle == null) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			}else{
				response = new Response(CommonConstants.NRG_SCUCESS, updatedVehicle, null);
			}
		}catch(Exception e){
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
				
		return response;
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Response deleteVehicle(@RequestBody Vechicle vehicle) {
		Response response = null;
		try{
			vehicleService.deleteVehicle(vehicle);			
		}catch(Exception e){
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
				
		return response;
	}
}
