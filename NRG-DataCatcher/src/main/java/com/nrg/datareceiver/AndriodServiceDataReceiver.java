package com.nrg.datareceiver;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/V1/dataReceiver/")
public class AndriodServiceDataReceiver {
	
	//@Value("${SAVE_ANDROID_SERVICEDATA}")
	//private String SAVE_ANDROID_SERVICEDATA;
	
/*	@RequestMapping(value = "/save", method = RequestMethod.POST)
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
	}*/
}
