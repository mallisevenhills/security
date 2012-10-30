package com.malli.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.malli.entity.User;
import com.malli.repo.UserRepo;
import com.malli.response.Account;
import com.malli.response.ResponseWrapper;

@Controller
@RequestMapping("/rest")
public class RestController {

	@Resource
	private UserRepo userRepo;
	
	@RequestMapping(value="/getUserDetails", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<User> getUserDetails() {
		return userRepo.findAll();
	}
	
	@RequestMapping(value="/getUserResponse", method=RequestMethod.GET, consumes="application/json", produces="application/json")
	@ResponseBody
	public ResponseWrapper<List<com.malli.response.User>> getUserResponse() {
		Iterable<User> users = userRepo.findAll();
		Iterator<User> user = users.iterator();
		List<com.malli.response.User> listUser = new ArrayList<com.malli.response.User>();
		
		while (user.hasNext()) {
			User us = user.next();
			com.malli.response.User resUser = new com.malli.response.User();
			Account acc = new Account();
			resUser.setAccount(acc);
			resUser.setName(us.getUsername());
			acc.setId(us.getId());
			acc.setAmount(Double.valueOf(String.valueOf(us.getId()) + 100.00));
			listUser.add(resUser);
		}
		return ResponseWrapper.success(listUser);
	}
	
	@RequestMapping(value="/postUserResponse", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public ResponseWrapper<List<com.malli.response.User>> postUserResponse(@RequestBody User u) {
		Iterable<User> users = userRepo.findAll();
		Iterator<User> user = users.iterator();
		List<com.malli.response.User> listUser = new ArrayList<com.malli.response.User>();
		
		while (user.hasNext()) {
			User us = user.next();
			com.malli.response.User resUser = new com.malli.response.User();
			Account acc = new Account();
			resUser.setAccount(acc);
			resUser.setName(us.getUsername());
			acc.setId(us.getId());
			acc.setAmount(Double.valueOf(String.valueOf(us.getId()) + 100.00));
			listUser.add(resUser);
		}
		return ResponseWrapper.success(listUser);
	}
}
