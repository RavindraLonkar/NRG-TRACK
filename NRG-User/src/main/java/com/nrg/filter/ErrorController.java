package com.nrg.filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

	private static final String ERROR_MAPPING = "/error";

	@RequestMapping(value = ERROR_MAPPING)
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error/404");
		return modelAndView;
	}

	@Override
	public String getErrorPath() {
		return ERROR_MAPPING;
	}

}
