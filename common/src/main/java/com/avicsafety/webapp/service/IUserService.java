package com.avicsafety.webapp.service;

import java.util.List;

import com.avicsafety.webapp.entity.User;


public interface IUserService {
	public void AddUser(User user);
	public List<User> findUserByUsername(String username);
	public User getCurrentUser();
	public User saveUser(User user);

}
