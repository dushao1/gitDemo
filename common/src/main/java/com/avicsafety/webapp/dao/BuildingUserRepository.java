package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.avicsafety.webapp.entity.BuildingUser;

@RepositoryRestResource(path="building_user")
public interface BuildingUserRepository extends JpaRepository<BuildingUser, Long> {

	List<BuildingUser> findByBidAndType(Long bid, String type);
	
	List<BuildingUser> findByBid(@Param("bid") Long bid);
}
