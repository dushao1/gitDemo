package com.avicsafety.webapp.dao;

import java.util.List;
import com.avicsafety.webapp.entity.Role;
import com.avicsafety.webapp.entity.User;

public interface UserCustomRepository {

	public List<User> getMyList();
	User saveUser(User user, List<Role> roles);
}
