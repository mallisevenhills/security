package com.malli.sec;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class MainAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	 @Resource private UserDetailsService userDetailsService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		
		String creds = (String) authentication.getCredentials();
        String passwd = userDetails.getPassword();
        @SuppressWarnings("unused")
		String path = (String) authentication.getDetails();
       
        if(!StringUtils.equals(creds, passwd))
            throw new BadCredentialsException("password not match");
		
	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		return userDetailsService.loadUserByUsername(username);
	}
	
	public UsernamePasswordAuthenticationToken getAuth(String username) {
        UserDetails principal = retrieveUser(username, null);
        UsernamePasswordAuthenticationToken authObj =
                new UsernamePasswordAuthenticationToken(principal,
                        principal.getPassword(), principal.getAuthorities());
        return authObj;
    }

}
