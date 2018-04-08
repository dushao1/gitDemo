package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.Community;

@RepositoryRestResource(path="community")
public interface CommunityRepository extends JpaRepository<Community, Long> {
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from Community u where u.del=0 order by sort")
    Page<Community> findAll(Pageable pageable);
	
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
	Community findOne(Long id);
	
	List<Community> findByDistrictAndDelFalseOrderBySort(@Param("district") String district);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Community m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
