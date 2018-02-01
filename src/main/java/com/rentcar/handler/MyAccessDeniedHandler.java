package com.rentcar.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MyAccessDeniedHandler implements AccessDeniedHandler{
	
	private static Logger logger = LoggerFactory.getLogger(MyAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp, AccessDeniedException e)
			throws IOException, ServletException {
		
		Authentication auth
        = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
            logger.info("User '" + auth.getName()
                    + "' attempted to access the protected URL: "
                    + req.getRequestURI());
        }
		resp.sendRedirect(req.getContextPath() + "/403");
	}
	
}
