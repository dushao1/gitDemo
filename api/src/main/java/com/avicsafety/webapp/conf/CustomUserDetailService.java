package com.avicsafety.webapp.conf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.entity.User;
import com.avicsafety.webapp.service.IUserService;

@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired   
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<com.avicsafety.webapp.entity.User> users = userService.findUserByUsername(username);
		if(users==null||users.size()==0){
			throw new UsernameNotFoundException("");
		}
		User user = users.get(0);
		return user;
	}
}
