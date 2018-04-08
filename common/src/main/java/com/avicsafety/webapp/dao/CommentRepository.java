package com.avicsafety.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.Comment;

@RepositoryRestResource(path="comment")
public interface CommentRepository extends JpaRepository<Comment, Long>{
   
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from Comment u where u.del=0 order by u.createdate desc")
    Page<Comment> findAll(Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Comment m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    @Query("from Comment s where s.guid = ? and s.del=0 order by s.createdate desc")
	Page<Comment> findCommentByGuid(String guid, Pageable pageable);


}
