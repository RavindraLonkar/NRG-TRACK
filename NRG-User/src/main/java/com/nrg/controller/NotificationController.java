/**
 * 
 */
package com.nrg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nrg.models.User;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

/**
 * @author namdev
 *
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Value("${GET_NOTIFICATION_INSURANCE_LIST}")
	private String GET_NOTIFICATION_INSURANCE_LIST;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response vehiclePositions(HttpServletRequest request) {
		Response response = null;
		try {
			User user = (User) request.getSession().getAttribute("usersession");
			RestTemplate restTemplate = new RestTemplate();
			String vehicleListUrl = GET_NOTIFICATION_INSURANCE_LIST + "?userId=" + user.getUserid();
			response = restTemplate.getForObject(vehicleListUrl, Response.class);

		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

}
