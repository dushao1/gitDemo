package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.Article;
import com.avicsafety.webapp.entity.User;

@RepositoryRestResource(path="article")
public interface ArticleRepository extends JpaRepository<Article, Long>{
   
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from Article u where u.del=0")
    Page<Article> findAll(Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Article m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    @RestResource(exported = false)
    List<Article> findByTitleAndDelFalse(String title);
    
    
}
