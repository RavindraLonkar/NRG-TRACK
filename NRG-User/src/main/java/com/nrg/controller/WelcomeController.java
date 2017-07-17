/**
 * 
 */
package com.nrg.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.User;

/**
 * @author Namdev
 *
 */
@RestController
public class WelcomeController {

	@RequestMapping(value = "/build/session", method = RequestMethod.GET)
	public ModelAndView buildsession() {
		return new ModelAndView("redirect:" + "/home");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView loadHome(ServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		HttpServletRequest req=(HttpServletRequest) request;
		req.getSession();
		User user=(User) req.getSession().getAttribute("usersession");
		modelAndView.addObject("usersesson",user.getUsername());
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
