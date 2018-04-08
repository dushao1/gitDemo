package com.avicsafety.webapp.service;

import java.util.List;

import com.avicsafety.webapp.entity.Role;

public interface IRoleService {
	List<Role> getRoleListByUserId(Long id);
}
