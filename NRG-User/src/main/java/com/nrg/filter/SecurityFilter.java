package com.nrg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nrg.security.token.NRGToken;
import com.nrg.utils.CommonUtils;

@Component  
@Order(Ordered.HIGHEST_PRECEDENCE)  
public class SecurityFilter implements Filter {  
  
	@Value("${MATCH_USER_KEY}")
	private String MATCH_USER_KEY;

	@Value("${ENCY_USER_KEY}")
	private String ENCY_USER_KEY;
	
	@Value("${REDIRECT_LOGIN_URL}")
	private String REDIRECT_LOGIN_URL;
	
  
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
  
    }  
  
	@Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
    	String userName = request.getParameter("userName");
    	String decryKey=NRGToken.decrypt(userName, ENCY_USER_KEY);
    	if(decryKey==null){
    		CommonUtils.redirectUrl(REDIRECT_LOGIN_URL);
    	}else{
    		String UserKey[]=decryKey.split("|");
    		if(UserKey[1].equals(MATCH_USER_KEY)){
    			 chain.doFilter(request,response);  
    		}else{
    			CommonUtils.redirectUrl(REDIRECT_LOGIN_URL);
    		}
    		
    	}
  
    }  
  
    @Override  
    public void destroy() {  
  
    }  
}  