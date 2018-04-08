package com.avicsafety.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.entity.BuildingUser;
import com.avicsafety.webapp.service.IBuildingUserService;



@RestController
public class BuildingController {
	
	 @Autowired
	 IBuildingUserService BuildingUserManager;
	
	 @RequestMapping(value="/api/building_user/add")
	 public BuildingUser add(@RequestParam("type") String type,@RequestParam("cid") Long cid,@RequestParam("bid") Long bid,@RequestParam("uid") Long uid) {
		 return BuildingUserManager.add(type,cid,bid,uid);
	 }

}
