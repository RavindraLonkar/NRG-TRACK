package com.nrg.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.User;
import com.nrg.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody User employee) {
		System.out.println(employee);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public User session(@RequestParam("username") String username) {
		return userService.session(username);
	}
}
