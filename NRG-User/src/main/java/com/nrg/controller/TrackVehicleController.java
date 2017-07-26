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
 * @author Gourab
 *
 */
@RestController
public class TrackVehicleController {

	@Value("${USER_SESSION_DATA}")
	private String USER_SESSION_DATA;

	@RequestMapping(value = "/trackVehicle", method = RequestMethod.GET)
	public ModelAndView trackVehicle(HttpServletRequest request) {
				
		return new ModelAndView("VehicleTrack");
	}

	
	
	
}
