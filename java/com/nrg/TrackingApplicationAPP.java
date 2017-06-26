package com.nrg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
@EnableAutoConfiguration
public class TrackingApplicationAPP extends SpringBootServletInitializer {
		
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TrackingApplicationAPP.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TrackingApplicationAPP.class, args);
	}	
	
}
