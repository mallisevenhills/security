package com.malli.controller;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.malli.entity.Role;
import com.malli.entity.User;
import com.malli.repo.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource UserRepo userRepo;
	
	@Resource UserDetailsService userDetailService;
	
	
	@RequestMapping(value="/showRegisterForm", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
            User registerForm = new User();
            model.addAttribute("registerForm", registerForm);
            return "registerForm";
    }
	
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("registerForm") User registerForm) {
		User user = User.with(registerForm.getUsername(), 
				registerForm.getPassword());
		user.setRole(Role.ADMIN);		
		user = userRepo.save(user);
    	ModelAndView view = new ModelAndView("registrationSuccess");
    	view.addObject("register", user);
        return view;
    }
	
	
}
