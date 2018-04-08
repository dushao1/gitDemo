package com.avicsafety.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.MemberLog;

@RepositoryRestResource(path="member_log")
public interface MemberLogRepository extends JpaRepository<MemberLog, Long> {
	
	
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(MemberLog m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();

	Page<MemberLog> findByMemid(Long memid, Pageable pageable);
}
