package com.rentcar.handler;


import java.io.IOException;

import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.rentcar.entity.User;
import com.rentcar.service.UserServiceImpl;


@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired
	UserServiceImpl userService;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth)
			throws IOException, ServletException {
		handle(req, resp, auth);
        clearAuthenticationAttributes(req);
		
	}

	protected void handle(HttpServletRequest request, 
		      HttpServletResponse response, Authentication authentication)
		      throws IOException {
		  
		        String targetUrl = determineTargetUrl(authentication);
		
		 
		        redirectStrategy.sendRedirect(request, response, targetUrl);
		    }
		 
		    protected String determineTargetUrl(Authentication authentication) {
		    	Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		    	String email = authentication.getName().toString().toLowerCase();
		    	User user = userService.getUserByEmail(email);
		    	if(user.getActive() == 1){
		    		if (authorities.contains("SUPER_ADMIN")) {
			        	return "/super_admin";
			        }else  if (authorities.contains("ADMIN")) {
			        	return "/admin";
			        } else if (authorities.contains("USER")) {
			        	return "/user";
			        } else {
			            throw new IllegalStateException();
			        }
		    	}
		    	else{
		    		return null;
		    	}
		    	
		    }
		 
		    protected void clearAuthenticationAttributes(HttpServletRequest request) {
		        HttpSession session = request.getSession(false);
		        if (session == null) {
		            return;
		        }
		        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		    }
		 
		    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		        this.redirectStrategy = redirectStrategy;
		    }
		    protected RedirectStrategy getRedirectStrategy() {
		        return redirectStrategy;
		    }
}
