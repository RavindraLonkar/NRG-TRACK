package com.nrg.utils;

import org.springframework.web.servlet.ModelAndView;

import groovy.lang.Singleton;

@Singleton
public class CommonUtils {

	
	public static ModelAndView redirectUrl(String url){
		return new ModelAndView("redirect:"+url);
	}
}
