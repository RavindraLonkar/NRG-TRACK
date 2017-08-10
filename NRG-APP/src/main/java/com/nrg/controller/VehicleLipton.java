package com.nrg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.Vechicle;
import com.nrg.models.VehiclePosition;
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
		try {
			String userid = request.getParameter("userId");
			List<Vechicle> vehicle = vehicleService.getVehiclesList(Integer.parseInt(userid));

			if (vehicle.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, vehicle, CommonUserMessages.VEHICLE_LOADED);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response addVehicle(@RequestBody Vechicle vehicle, HttpServletRequest request) {
		Response response = null;
		try {
			String userid = request.getParameter("userId");
			Vechicle addedVehicle = vehicleService.addVehicle(vehicle, Integer.parseInt(userid));

			if (addedVehicle == null) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, addedVehicle, CommonUserMessages.VEHICLE_ADDED);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateVehicle(@RequestBody Vechicle vehicle, HttpServletRequest request) {
		Response response = null;
		try {
			Vechicle updatedVehicle = vehicleService.updateVehicle(vehicle);

			if (updatedVehicle == null) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, updatedVehicle,
						CommonUserMessages.VEHICLE_UPDATED);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Response deleteVehicles(@RequestBody List<Vechicle> vehicles) {
		Response response = null;
		try{
			vehicleService.deleteVehicles(vehicles);	
			response = new Response(CommonConstants.NRG_SCUCESS, 1, CommonUserMessages.VEHICLES_DELETED);
		}catch(Exception e){
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
				
		return response;
	}

	@RequestMapping(value = "/current/Position", method = RequestMethod.GET)
	public Response vehiclePositions(HttpServletRequest request) {
		Response response = null;
		try {
			String userid = request.getParameter("userId");
			List<VehiclePosition> vehicle = vehicleService.vehiclePositions(Integer.parseInt(userid));

			if (vehicle.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, vehicle, null);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}
}
