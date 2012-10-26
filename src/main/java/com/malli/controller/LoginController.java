package com.malli.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.malli.entity.User;
import com.malli.repo.UserRepo;

@Controller
public class LoginController {
	
	@Resource UserRepo userRepo;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLoginPage() {
            return "pub/login";
    }
	
	@RequestMapping(value="/pub/login", method = RequestMethod.GET)
    public String getDeniedPage() {
            return "pub/login";
    }
	
	@RequestMapping(value="/menu", method = RequestMethod.GET)
    public String getMenuPage() {
            return "menu";
    }
	
	@RequestMapping(value="/userdetails", method = RequestMethod.GET)
    public ModelAndView userDetails() {
		Iterable<User> allUser = userRepo.findAll();
    	ModelAndView view = new ModelAndView("menu");
    	view.addObject("menu", allUser);
        return view;
    }

}
