package com.malli.sec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MainAccessDeniedHandler implements AccessDeniedHandler {
	
	public String redirectPage;

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
			ServletException {
		
		 if (!response.isCommitted()) {            
	            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + redirectPage));
	        } else {
	            response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
	        }
	}
	
	public String getRedirectPage() {
        return redirectPage;
    }

    public void setRedirectPage(String redirectPage) {
        this.redirectPage = redirectPage;
    }

}
