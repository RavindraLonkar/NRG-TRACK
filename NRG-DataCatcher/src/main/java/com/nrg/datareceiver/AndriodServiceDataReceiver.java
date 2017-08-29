package com.nrg.datareceiver;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nrg.models.TrackingData;
import com.nrg.utils.Response;

@RestController
@RequestMapping("api/V1/dataReceiver/")
public class AndriodServiceDataReceiver {
	
	//@Value("${SAVE_ANDROID_SERVICEDATA}")
	//private String SAVE_ANDROID_SERVICEDATA;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response saveAndroidServiceData(@RequestBody TrackingData trackingData){
		Response response = null;
		//String url=SAVE_ANDROID_SERVICEDATA;
		//RestTemplate rs=new RestTemplate();
		//response=rs.postForObject(url, trackingData, Response.class);
		return response;
	}
	
	@RequestMapping(value = "/run", method = RequestMethod.GET)
	public void runFtp() throws IOException{
		System.out.println("ffffffffffffffffffffff");
		String str;
	  @SuppressWarnings("resource")
	  ServerSocket welcomeSocket = new ServerSocket(9000);

	  while (true) {
	   System.out.println("Received***************************************************************************");
	   Socket connectionSocket = welcomeSocket.accept();
	   BufferedReader inFromClient =new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	   DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
	   str = inFromClient.readLine();
	   System.out.println("Received: " + str);
	  // saveData.saveDetails(str);
	  //capitalizedSentence = clientSentence.toUpperCase() + '\n';
	  //outToClient.writeBytes(capitalizedSentence);
	  }
	}
}
