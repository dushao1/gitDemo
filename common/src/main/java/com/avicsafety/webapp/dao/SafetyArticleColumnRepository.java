package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.SafetyArticle;
import com.avicsafety.webapp.entity.SafetyArticleColumn;
import com.avicsafety.webapp.entity.Thumbsup;

@RepositoryRestResource(path="safetyarticlecolumn")
public interface SafetyArticleColumnRepository extends JpaRepository<SafetyArticleColumn, Long>{
   
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from SafetyArticleColumn u where u.del=0")
    Page<SafetyArticleColumn> findAll(Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(SafetyArticleColumn m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    @Query("from SafetyArticleColumn s where s.colid = ? and s.del=0")
    List<SafetyArticleColumn> findSafetyArticleColumnByColid(int colid);



}
