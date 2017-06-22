package com.nrg.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.TXN_User;

@RestController
@RequestMapping("/user")
public class UserController {
		
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody TXN_User employee) 
	{
	    System.out.println(employee);
	    return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
