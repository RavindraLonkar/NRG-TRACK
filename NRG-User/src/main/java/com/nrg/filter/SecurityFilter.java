package com.nrg.filter;

import java.io.IOException;
import java.util.Map;

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
import org.springframework.web.servlet.support.RequestContextUtils;

import com.nrg.security.token.NRGToken;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityFilter implements Filter {

	@Value("${REDIRECT_LOGIN_URL}")
	private String REDIRECT_LOGIN_URL;

	@Value("${SESSION_TIMEOUT_SECONDS}")
	private String SESSION_TIMEOUT_SECONDS;

	@Value("${LOGIN_URL}")
	private String LOGIN_URL;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		if (url.contains("build/session")) {
			if (session.isNew()) {
				session.setMaxInactiveInterval(Integer.parseInt(SESSION_TIMEOUT_SECONDS));
				chain.doFilter(request, response);
			} else {
				session.invalidate();
				// Redirect to welcome page
				res.sendRedirect(LOGIN_URL);
			}
		} else if (url.contains("logout")) {
			session.invalidate();
			// Redirect to welcome page
			res.sendRedirect(LOGIN_URL);
		} else {
			if (req.getSession(false) != null && !session.isNew()) {
				chain.doFilter(request, response);
			} else {
				// Redirect to welcome page
				session.invalidate();
				res.sendRedirect(LOGIN_URL);
			}
		}
	}

	@Override
	public void destroy() {

	}
}