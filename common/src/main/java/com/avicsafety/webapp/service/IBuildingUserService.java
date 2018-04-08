package com.avicsafety.webapp.service;

import com.avicsafety.webapp.entity.BuildingUser;

public interface IBuildingUserService {

	BuildingUser add(String type,Long cid, Long bid, Long uid);

}
