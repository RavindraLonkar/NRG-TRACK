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

import com.nrg.models.Insurance;
import com.nrg.models.User;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

/**
 * @author Ravindra
 *
 */
@RestController
@RequestMapping("/insurance")
public class InsuranceController {

	@Value("${GET_INSURANCE_LIST}")
	private String GET_INSURANCE_LIST;
	
	@Value("${UPDATE_INSURANCE}")
	private String UPDATE_INSURANCE;
	
	@Value("${SAVE_INSURANCE}")
	private String SAVE_INSURANCE;
	
	@Value("${DELETE_INSURANCES}")
	private String DELETE_INSURANCES;

	//------------------------------------------------------	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView registration(HttpServletRequest request) {
		return new ModelAndView("vehicleInsurance");
	}

	//------------------------------------------------------	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getInsuranceList(HttpServletRequest request) {

		Response response = null;
		try {
			User user = (User) request.getSession().getAttribute("usersession");

			RestTemplate restTemplate = new RestTemplate();
			String insuranceListUrl = GET_INSURANCE_LIST + "?userId=" + user.getUserid();
			response = restTemplate.getForObject(insuranceListUrl, Response.class);

		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}
	
	//------------------------------------------------------
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response addInsurance(@RequestBody Insurance insurance, HttpServletRequest request) {

		Response response = null;
		try {
			User user = (User) request.getSession().getAttribute("usersession");

			RestTemplate restTemplate = new RestTemplate();
			String insuranceListUrl = SAVE_INSURANCE + "?userId=" + user.getUserid();
			response = restTemplate.postForObject(insuranceListUrl, insurance, Response.class);

		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}
	
	//------------------------------------------------------
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Response updateInsurance(@RequestBody Insurance insurance) {

		Response response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String insuranceListUrl = UPDATE_INSURANCE;
			response = restTemplate.postForObject(insuranceListUrl, insurance, Response.class);
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
		return response;
	}
	
	//------------------------------------------------------	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Response deleteInsurance(@RequestBody List<Insurance> insuranceList) {

		Response response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String insuranceListUrl = DELETE_INSURANCES;
			response = restTemplate.postForObject(insuranceListUrl, insuranceList, Response.class);
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}
		return response;
	}
	//------------------------------------------------------	
		
}
