package com.malli.sec;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class MainUpaFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		System.out.println("Obtain password");
		return super.obtainPassword(request);
	}

	@Override
	protected void setDetails(HttpServletRequest request,
			UsernamePasswordAuthenticationToken authRequest) {
		System.out.println("setDetails");

        String path = request.getRequestURI();
        String ctx = request.getContextPath();
        
        String firstPath = path.replaceFirst(ctx, "");
        firstPath = firstPath.substring(0, firstPath.lastIndexOf("/"));
        authRequest.setDetails(firstPath);
	}

}
