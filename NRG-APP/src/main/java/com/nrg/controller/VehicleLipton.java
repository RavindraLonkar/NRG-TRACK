package com.nrg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.User;
import com.nrg.models.VehicleDetails;
import com.nrg.services.VehicleService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/vehicle")
public class VehicleLipton {
	@Autowired
	VehicleService vehicleService;

	
	@RequestMapping(value = "/lists", method = RequestMethod.GET)
	public Response getVehiclesOfUser(HttpServletRequest request) {
		Response response = null;
		try{
			String userid = request.getParameter("userId");
			User user=new User();
			//user.setUserid( Long.parseLong(userid, 1)  );
			List<VehicleDetails> vehicle = vehicleService.getVehiclesOfUser(Integer.parseInt(userid));
			
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
}