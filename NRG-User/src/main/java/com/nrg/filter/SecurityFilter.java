package com.nrg.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component  
@Order(Ordered.HIGHEST_PRECEDENCE)  
public class SecurityFilter implements Filter {  
  
    private static final boolean CONDITION = true;  
  
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
  
    }  
  
    @SuppressWarnings("unused")
	@Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
    	String Name = request.getParameter("USER_NAME");
    			
        if(CONDITION==true)  
            chain.doFilter(request,response);  
        else{  
            ((HttpServletResponse)response).setStatus(HttpServletResponse.SC_BAD_REQUEST);  
        }  
  
    }  
  
    @Override  
    public void destroy() {  
  
    }  
}  