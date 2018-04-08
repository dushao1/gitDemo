package com.avicsafety.webapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.avicsafety.webapp.entity.Role;
import com.avicsafety.webapp.entity.User;

@RepositoryRestResource(path="user")
public class UserRepositoryImpl implements UserCustomRepository  {


	@PersistenceContext
    private EntityManager em;

	@Override
	public List<User> getMyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(User user, List<Role> roles) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
