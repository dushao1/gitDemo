package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.Building;
import com.avicsafety.webapp.entity.Community;

@RepositoryRestResource(path="building")
public interface BuildingRepository extends JpaRepository<Building, Long> {
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from Building u where u.del=0 order by sort")
    Page<Building> findAll(Pageable pageable);
	
	Page<Building> findByCidAndDelFalse(@Param("cid") Long cid,Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Building m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
