package com.avicsafety.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.WebAttachments;

@RepositoryRestResource(path="image")
public interface WebAttachmentsRepository extends JpaRepository<WebAttachments, Long>{
   
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from WebAttachments u where u.del=0")
    Page<WebAttachments> findAll(Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(WebAttachments m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    
    @Query("from WebAttachments u where u.path=? and u.del=0")
    WebAttachments findWebAttachmentsByPath(String path);
    
    @Query("from WebAttachments u where u.id=? and u.del=0")
    WebAttachments findWebAttachmentsById(long id);

}
