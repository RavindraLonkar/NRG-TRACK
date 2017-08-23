package com.nrg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.InsuranceNotificationDetails;
import com.nrg.services.NotificationService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/notification")
public class NotificationLipton {

	@Autowired
	NotificationService notificationService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getVehiclesOfUser(HttpServletRequest request) {
		Response response = null;
		try {
			String userid = request.getParameter("userId");
			List<InsuranceNotificationDetails> notification =notificationService.getInsuranceNotificationList(Integer.parseInt(userid));

			if (notification.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, 0, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, notification, CommonUserMessages.INSURANCE_NOTIFICATION_LIST_SUCCESS);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

	
}
