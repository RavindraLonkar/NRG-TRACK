package com.nrg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.User;
import com.nrg.services.UserService;

@RestController
@RequestMapping("/service/login")
public class LoginFacade {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public User findUserByusername(@RequestBody User user){
		
		return userService.findUserByusername(user.getUsername());
		
	}
}
