package com.avicsafety.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.RoleRepository;
import com.avicsafety.webapp.dao.UserRepository;
import com.avicsafety.webapp.entity.Role;
import com.avicsafety.webapp.entity.User;
import com.avicsafety.webapp.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	private static final Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	@Autowired
	UserRepository dao;
	
	@Autowired
	RoleRepository role_dao;

	@Override
	public void AddUser(User user) {
		// TODO Auto-generated method stub
		dao.save(user);
		logger.info("add user");
	}


	@Override
	public List<User> findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndDelFalse(username);
	}


	@Override
	public User getCurrentUser() {

		User userDetails = (User) SecurityContextHolder.getContext()  
			    .getAuthentication()  
			    .getPrincipal();  
		
		return userDetails;
			  
//		 String name = userDetails.getUsername();
//		 List<User> list = dao.findByUsername(name);
//		 if(list==null||list.size()==0) {
//			 return null;
//		 }else {
//			 return list.get(0);
//		 }
		
	}


	@Override
	public User saveUser(User user) {
		List<Long> ids = new ArrayList<>();
		for(Role role:user.getRoles()) {
			ids.add(role.getId());
		}
		List<Role> roles = role_dao.findAll(ids);
		user.setRoles(roles);
		
		if(user.getId()!=null) {
			User existing = dao.getOne(user.getId());
			BeanUtils.copyProperties(user, existing);
			return dao.save(existing);
		}else {
			return dao.save(user);
		}

	}
}
