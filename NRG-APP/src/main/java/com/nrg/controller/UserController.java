package com.nrg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.User;
import com.nrg.services.UserService;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	Response response = new Response();
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response createNewUser(@RequestBody User user) {
		return  userService.saveClient(user);
	}

	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public User session(@RequestParam("username") String username) {
		return userService.session(username);
	}
}
