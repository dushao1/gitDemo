package com.avicsafety.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.entity.User;
import com.avicsafety.webapp.service.IUserService;



@RestController
public class UserController {
	
	 @Autowired
	 IUserService UserManager;
	
	 @RequestMapping(value="/api/user/save")
	 public User saveUser(@RequestBody User user) {
		 return UserManager.saveUser(user);
	 }

}
