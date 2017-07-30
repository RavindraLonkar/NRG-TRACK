package com.nrg.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nrg.models.User;
import com.nrg.utils.Response;

@RestController
public class ForgotPasswordController {

	@Value("${FIND_USER_BY_EMAIL_PASSWORD_CHANGE}")
	private String FIND_USER_BY_EMAIL_PASSWORD_CHANGE;
	
	Response response = new Response();
	

	@RequestMapping(value = "/passwordrequest", method = RequestMethod.GET)
	public Response saveAndroidServiceData(ServletRequest req) {
		RestTemplate rs = new RestTemplate();
		User userData = new User();
		String emailId = req.getParameter("emailid");
		userData.setEmailid(emailId);
		String url = FIND_USER_BY_EMAIL_PASSWORD_CHANGE;
		try {
			response = rs.postForObject(url, userData, Response.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

}
