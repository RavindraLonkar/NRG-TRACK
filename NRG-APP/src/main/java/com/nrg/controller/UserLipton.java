package com.nrg.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.User;
import com.nrg.services.UserService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/user")
public class UserLipton {

	@Autowired
	UserService userService;

	Response response =null;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response createNewUser(@RequestBody User user, final Locale locale) {
		User userResponse = new User();
		userResponse = userService.saveClient(user,locale);
		if (userResponse != null) {
			return new Response(CommonConstants.NRG_SCUCESS, userResponse, CommonUserMessages.NRG_USER_SAVE_SUCCESS);
		} else {
			return new Response(CommonConstants.NRG_FAIL, null, "");
		}
	}

	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public User session(@RequestParam("username") String username) {
		return userService.session(username);
	}

	@RequestMapping(value = "/change/password", method = RequestMethod.POST)
	public Response changePassword(@RequestBody User user) {
		User userResponse = new User();
		userResponse = userService.updatePassword(user);
		if (userResponse != null) {
			return new Response(CommonConstants.NRG_SCUCESS, userResponse,
					CommonUserMessages.USER_PASSWORD_UPDATE_SUCCESS);
		} else {
			return new Response(CommonConstants.NRG_FAIL, null, "");
		}
	}
	
	@RequestMapping(value = "/confirm/email", method = RequestMethod.POST)
	public Response confirmEmail(@RequestBody User user) {
		User userResponse = new User();
		userResponse = userService.comfirmEmail(user);
		if (userResponse != null) {
			return new Response(CommonConstants.NRG_SCUCESS, userResponse,
					CommonUserMessages.CONFIRM_EMAIL_SUCCESS);
		} else {
			return new Response(CommonConstants.NRG_FAIL, null, "");
		}
	}
	
	@RequestMapping(value = "/profile/save", method = RequestMethod.POST)
	public Response profile(@RequestBody User user) {
		User userResponse = new User();
		userResponse = userService.saveClientProfile(user);
		if (userResponse != null) {
			return new Response(CommonConstants.NRG_SCUCESS, userResponse, CommonUserMessages.CLIENT_PROFILE_SAVE_SUCCESS);
		} else {
			return new Response(CommonConstants.NRG_FAIL, null, "");
		}
	}
	@RequestMapping(value = "/profile/get", method = RequestMethod.GET)
	public Response profile(HttpServletRequest request) {
		User userResponse=new User();
		Integer userId=Integer.parseInt(request.getParameter("userId"));
		userResponse = userService.findUserByuserid(userId);
		if (userResponse != null) {
			return new Response(CommonConstants.NRG_SCUCESS, userResponse, CommonUserMessages.CLIENT_PROFILE_SAVE_SUCCESS);
		} else {
			return new Response(CommonConstants.NRG_FAIL, null, "");
		}
	}
}
