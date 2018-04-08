package com.avicsafety.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.SafetyArticle;
import com.avicsafety.webapp.entity.Thumbsup;

@RepositoryRestResource(path="thumbsup")
public interface ThumbsupRepository extends JpaRepository<Thumbsup, Long>{
   
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from Thumbsup u where u.del=0")
    Page<Thumbsup> findAll(Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Thumbsup m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    @Query("from Thumbsup s where s.guid = ? and s.username=? and s.del=0")
	Thumbsup findThumbsupByGuidAndUsername(String guid, String username);



}
