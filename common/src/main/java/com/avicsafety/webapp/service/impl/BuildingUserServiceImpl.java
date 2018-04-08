package com.avicsafety.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.BuildingRepository;
import com.avicsafety.webapp.dao.BuildingUserRepository;
import com.avicsafety.webapp.dao.CommunityRepository;
import com.avicsafety.webapp.dao.UserRepository;
import com.avicsafety.webapp.entity.BuildingUser;
import com.avicsafety.webapp.service.IBuildingUserService;

@Service
public class BuildingUserServiceImpl implements IBuildingUserService {
	
	@Autowired
	CommunityRepository community_dao;
	
	@Autowired
	BuildingRepository building_dao;
	
	@Autowired
	UserRepository user_dao;

	@Autowired
	BuildingUserRepository dao;
	
	@Override
	public BuildingUser add(String type,Long cid, Long bid, Long uid) {
		// TODO Auto-generated method stub
		//获取 小区名
		String cname = community_dao.getOne(cid).getName();
		//获取楼宇名
		String bname = building_dao.getOne(bid).getName();
		//获取用户名
		String uname = user_dao.getOne(uid).getName();
		//存储
		BuildingUser entity = new BuildingUser();
		entity.setCid(cid);
		entity.setCname(cname);
		entity.setBid(bid);
		entity.setBname(bname);
		entity.setUid(uid);
		entity.setUname(uname);
		entity.setType(type);
		dao.save(entity);
		return entity;
	}

}
