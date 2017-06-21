package com.nrg.datareceiver;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AndriodServiceDataReceiver {

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public List<String> test(){
		System.out.println("1");
		return null;
	}
}
