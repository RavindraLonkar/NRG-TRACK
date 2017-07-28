/**
 * 
 */
package com.nrg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.TrackingData;
import com.nrg.models.User;
import com.nrg.models.VehiclePosition;
import com.nrg.utils.Response;

/**
 * @author Namdev
 *
 */
@RestController
public class WelcomeController {

	@Value("${USER_SESSION_DATA}")
	private String USER_SESSION_DATA;

	@RequestMapping(value = "/build/session", method = RequestMethod.GET)
	public ModelAndView buildsession(HttpServletRequest request) {
		try {
			String userName = (String) request.getSession().getAttribute("username");
			RestTemplate restTemplate = new RestTemplate();
			String sessionurl = USER_SESSION_DATA + "?username=" + userName;
			User result = restTemplate.getForObject(sessionurl, User.class);
			request.getSession().setAttribute("usersession", result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return new ModelAndView("redirect:" + "/home");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView loadHome() {
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value = "/vehicleList", method = RequestMethod.GET)
	public Response getVehicleList() {
		
		List<VehiclePosition> list=new ArrayList<VehiclePosition>(); 
		list.add(new VehiclePosition("MH12AS2112","22.890542","77.274856",1));
		list.add(new VehiclePosition("MH12AS2113","22.00","77.259052",2));
		list.add(new VehiclePosition("MH12AS2114","22.028249","77.157507",3));
		list.add(new VehiclePosition("MH12AS2115","22.80010128657071","77.259302",4));
		
		Response res=new Response("success",list,"");
		
		return res;
	}

}
