package com.nrg.configuration;

import java.lang.reflect.Method;

import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class AppConfig {
	private static final String API_PREFIX = "service";

	@Bean
	WebMvcRegistrationsAdapter restPrefixAppender() {
	    return new WebMvcRegistrationsAdapter() {
	        @Override
	        public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
	            return new RequestMappingHandlerMapping() {
	                @Override
	                protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
	                    RequestMappingInfo mappingForMethod = super.getMappingForMethod(method, handlerType);
	                    if (mappingForMethod != null) {
	                        return RequestMappingInfo.paths(API_PREFIX).build().combine(mappingForMethod);
	                    } else {
	                        return null;
	                    }
	                }
	            };
	        }
	    };
	}
}
