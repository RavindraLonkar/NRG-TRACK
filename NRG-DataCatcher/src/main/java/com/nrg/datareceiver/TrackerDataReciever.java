package com.nrg.datareceiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.datacatcher.utils.DataCatcherConstants;

/*@EnableScheduling
@EnableAutoConfiguration*/

@RestController
@RequestMapping("/dataReceiver")
public class TrackerDataReciever {

	@Autowired
	ThreadPoolTaskExecutor executor;
	
	@Autowired
	Environment environment;
	
	
	// @Scheduled(fixedRate = 10000)
	@RequestMapping(value = "/run", method = RequestMethod.GET)
	public void recieveSocketData() {

		byte[] messageByte = new byte[500000];
		boolean end = false;
		String messageString = "";

		try {
			/*Socket clientSocket;
			ServerSocket server;

			server = new ServerSocket(9000);
			clientSocket = server.accept();
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			int bytesRead = 0;

			messageByte[0] = in.readByte();
			// messageByte[1] = in.readByte();					
			ByteBuffer byteBuffer = ByteBuffer.wrap(messageByte, 0, 2);

			int bytesToRead = byteBuffer.getShort();
			System.out.println("About to read " + bytesToRead + " octets");*/

			// The following code shows in detail how to read from a TCP socket
			
			/*
			while (!end) {
				bytesRead = in.read(messageByte1);
				
				String SocketData = CommonUtils.toHexString(messageByte1);
				System.out.println(" On Date : " + new Date() + " " + SocketData);
				
				splitDataPackets(SocketData);
				if (messageString.length() == bytesToRead) {
					end = true;
				}
			}*/
			String messageByte1 = "78 78 0A 13 05 00 64 00 01 00 44 A6 83 0D 0A "
					+ "78 78 1F 12 0D 0B 0B 00 00 00 C0 00 00 00 00 00 00 00 00 00 20 00 01 94 16 27 9D 00 0D 55 00 45 C0 B0 0D 0A";
			processDataPackets(messageByte1.replace(" ", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processDataPackets(String socketData) {
		
		String[] dataPackets = socketData.replace(" ", "").replace("\n", "").split(DataCatcherConstants.START_BYTE);
		
		List<String> dataPacketList = Arrays.asList(dataPackets);
		
		for(String dataPacket : dataPacketList){
			
			List<Future<Boolean>> futureList = new ArrayList<Future<Boolean>>();
			
			if(dataPacket.equals("")) 
				continue;
			
			if(dataPacket.substring(2, 4).equals(DataCatcherConstants.LOCATION_PROTOCOL_NUMBER)){
				LocationDataPacketProcessor camsTrxnThread = new LocationDataPacketProcessor(dataPacket, environment);
				Future<Boolean> locationDataPacketProcessorThreadFuture = executor.submit(camsTrxnThread);
				futureList.add(locationDataPacketProcessorThreadFuture);
			}
						
		}
	}

}