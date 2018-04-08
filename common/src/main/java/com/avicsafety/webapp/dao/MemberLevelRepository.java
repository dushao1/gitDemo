package com.avicsafety.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.MemberLevel;

@RepositoryRestResource(path="member_level")
public interface MemberLevelRepository extends JpaRepository<MemberLevel, Long> {
	
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from MemberLevel u where u.del=0 order by score asc")
    Page<MemberLevel> findAll(Pageable pageable);

    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(MemberLevel m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
