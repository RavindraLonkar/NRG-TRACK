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
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.CoordinateDetail;
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

	
	@RequestMapping(value = "/trackingCoordinates", method = RequestMethod.GET)
	public Response trackingCoordinates(HttpServletRequest request) {
		
		List<CoordinateDetail> list=new ArrayList<CoordinateDetail>();
		list.add(new CoordinateDetail("1234","21.486934","86.924600"));
		list.add(new CoordinateDetail("1234","28.704059","77.102490"));
		//list.add(new CoordinateDetail("1234","28.704059","77.102490"));
		//list.add(new CoordinateDetail("1234","28.734059","78.102490"));
		//list.add(new CoordinateDetail("1234","28.454405","78.102490"));
		//list.add(new CoordinateDetail("1234","66.704059","77.102490"));
		list.add(new CoordinateDetail("1234","21.145800","79.088155"));
		list.add(new CoordinateDetail("1234","18.520430","73.856744"));
		
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
}
