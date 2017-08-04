package com.nrg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.User;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/user")
public class ClientController {

	@Value("${SAVE_CLIENT_PROFILE}")
	private String SAVE_CLIENT_PROFILE;

	Response response = null;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userProfile");
		return modelAndView;
	}
		

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public Response profileSave(@RequestBody User userProfile, HttpServletRequest request) {
		RestTemplate rest = new RestTemplate();
		String url = SAVE_CLIENT_PROFILE;
		try {
			User user = (User) request.getSession().getAttribute("usersession");
			userProfile.setUserid(user.getUserid());
			response = rest.postForObject(url, user, Response.class);
		} catch (

		Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}
}