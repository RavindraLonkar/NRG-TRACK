package com.nrg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.nrg.datareceiver.TrackerDataReciever;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	TrackerDataReciever trackerDataReciever;

	/**
	 * This event is executed as late as conceivably possible to indicate that
	 * the application is ready to service requests.
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {

		new Thread() {
			@Override
			public void run() {
				trackerDataReciever.recieveSocketData();
			}
		}.start();

		return;
	}

}