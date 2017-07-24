package com.nrg.forgot.password;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.User;
import com.nrg.utils.Response;

@RestController
public class ForgotPasswordController {

	@Value("${FORGOT_PASSWORD}")
	private String FORGOT_PASSWORD;

	@RequestMapping(value = "/passwordrequest", method = RequestMethod.POST)
	public Response saveAndroidServiceData(@Valid User user, BindingResult bindingResult ) {
		ModelAndView modelAndView = new ModelAndView();
		Response response = null;
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("login");
		} else {
		String url = FORGOT_PASSWORD;
		RestTemplate rs = new RestTemplate();
		response = rs.postForObject(url, user, Response.class);
		}
		return response;
	}

}
