package com.nrg.datareceiver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.utils.Response;

@RestController
@RequestMapping("/api")
public class AndriodServiceDataReceiver {

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public Response test(){
		System.out.println("1");
		return null;
	}
}
