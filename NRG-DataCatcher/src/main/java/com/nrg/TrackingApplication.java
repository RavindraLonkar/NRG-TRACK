package com.nrg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:urls.properties")
@EnableAutoConfiguration(exclude={SecurityAutoConfiguration.class,DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class TrackingApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TrackingApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TrackingApplication.class, args);
	}	
	
}
