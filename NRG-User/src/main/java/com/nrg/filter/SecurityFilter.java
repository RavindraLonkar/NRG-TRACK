package com.nrg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nrg.security.token.NRGToken;

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
    	HttpServletRequest req=(HttpServletRequest) request;
    	HttpServletResponse res=(HttpServletResponse) response;
		String userName = request.getParameter("userName");
		String url=req.getRequestURL().toString();
    	
    	HttpSession session=req.getSession();
    	if(url.contains("build/session")){
    		String decryKey=NRGToken.decrypt(userName, ENCY_USER_KEY);
    		if(decryKey!=null && decryKey.contains(MATCH_USER_KEY) && session.isNew()){
    			
    			session.setAttribute(userName, userName);
    			
    			chain.doFilter(request, response);
    		}
    		else{
    			session.invalidate();
    			//Redirect to welcome page
    			res.sendRedirect("/NRG-Welcome");
    		}
    	}
    	else if(url.contains("logout")){
	    		session.invalidate();
				//Redirect to welcome page
				res.sendRedirect("/NRG-Welcome");
    	}
    	else{
    		if(req.getSession(false)!=null && !session.isNew()){
    			chain.doFilter(request, response);
    		}
    		else{
    			//Redirect to welcome page
    			res.sendRedirect("/NRG-Welcome");    		}
    	}
    	
    	

  
    }  
  
    @Override  
    public void destroy() {  
  
    }  
}  