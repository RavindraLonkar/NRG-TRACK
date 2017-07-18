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
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.User;

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
			
		}
	
		return new ModelAndView("redirect:" + "/home");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView loadHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
