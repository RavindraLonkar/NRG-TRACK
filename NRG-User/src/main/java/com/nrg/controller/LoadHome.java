/**
 * 
 */
package com.nrg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Namdev
 *
 */
@RestController
@RequestMapping("/home")
public class LoadHome {
	

	@RequestMapping(value="/build/session", method=RequestMethod.GET)
	public ModelAndView buildsession(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("userView");
		System.out.println("incide controller");
		
		
		return modelAndView;
	}
}