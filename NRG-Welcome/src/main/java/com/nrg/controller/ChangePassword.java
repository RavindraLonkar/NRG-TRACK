package com.nrg.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.User;
import com.nrg.utils.Response;

@RestController
public class ChangePassword {
	
	@Value("${FIND_USER_BY_EMAIL}")
	private String FIND_USER_BY_EMAIL;
	
	Response response = new Response();

	
	@RequestMapping(value = {"/changepassword" }, method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String token=request.getParameter("token");
		modelAndView.setViewName("changepassword");
		return modelAndView;
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public Response saveAndroidServiceData(ServletRequest req) {
		RestTemplate rs = new RestTemplate();
		User userData = new User();
		String emailId = req.getParameter("emailid");
		userData.setEmailid(emailId);
		String url = FIND_USER_BY_EMAIL;
		try {
			response = rs.postForObject(url, userData, Response.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

}
