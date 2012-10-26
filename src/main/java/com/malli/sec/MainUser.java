package com.malli.sec;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.malli.entity.User;

public class MainUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 242947638469224331L;
	
    private User user;
    
    public MainUser(User user) {
        this.user = user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
      GrantedAuthority ga = null;
        
        if(user.isAdmin())
            ga = new SimpleGrantedAuthority("ROLE_ADMIN");
        else if(user.isPub())
            ga = new SimpleGrantedAuthority("ROLE_PUB");
        else if(user.isVisitor())
            ga = new SimpleGrantedAuthority("ROLE_VISITOR");
        else
            ga = new SimpleGrantedAuthority("ROLE_ANONYMOUS");

        Collection<GrantedAuthority> c = new ArrayList<GrantedAuthority>();
        c.add(ga);
        return c;
	}

	@Override
	public String getPassword() {
		if (user == null) return null;
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
