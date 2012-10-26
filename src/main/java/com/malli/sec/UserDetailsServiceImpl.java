package com.malli.sec;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.malli.entity.User;
import com.malli.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Resource private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			System.out.println("**************** " + userRepo);
            User u = userRepo.findByUsername(username);
            UserDetails ud = new MainUser(u);   
            return ud;
        } catch(Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
	}

}
