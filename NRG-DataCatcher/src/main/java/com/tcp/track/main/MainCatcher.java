package com.tcp.track.main;

import java.io.*;
import java.net.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.tcp.track.service.SaveData;

@Component
public class MainCatcher implements ApplicationListener<ApplicationReadyEvent> {
	@Autowired
	SaveData saveData;
	
	{
		try {
			 System.out.println("Received***************************************************************************");
			track();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void track() throws Exception {
	  String str;
	  @SuppressWarnings("resource")
	  ServerSocket welcomeSocket = new ServerSocket(1234);

	  while (true) {
		  System.out.println("Received***************************************************************************");
	   Socket connectionSocket = welcomeSocket.accept();
	   BufferedReader inFromClient =new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	   DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
	   str = inFromClient.readLine();
	   System.out.println("Received: " + str);
	   saveData.saveDetails(str);
	  // capitalizedSentence = clientSentence.toUpperCase() + '\n';
	  // outToClient.writeBytes(capitalizedSentence);
	  }
	 }

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		
		 System.out.println("Received");
	}}
