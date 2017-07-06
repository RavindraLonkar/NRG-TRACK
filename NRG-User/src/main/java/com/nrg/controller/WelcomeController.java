/**
 * 
 */
package com.nrg.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Namdev
 *
 */
@RestController
public class WelcomeController {
	

	@RequestMapping(value="/build/session", method=RequestMethod.GET)
	public ModelAndView buildsession(){
		
		System.out.println("incide controller");
		return new ModelAndView("redirect:" + "/home/loadHome");
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView loadHome(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
}
