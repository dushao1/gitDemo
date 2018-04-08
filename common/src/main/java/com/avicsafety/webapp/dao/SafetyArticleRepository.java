package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.avicsafety.webapp.entity.SafetyArticle;

@RepositoryRestResource(path="safetyarticle")
public interface SafetyArticleRepository extends JpaRepository<SafetyArticle, Long>{
   
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from SafetyArticle u where u.del=0 order by u.createdate desc")
    Page<SafetyArticle> findAll(Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(SafetyArticle m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    @Query("from SafetyArticle s where s.title like ? and s.del=0 order by s.createdate desc")
    Page<SafetyArticle> findSafetyArticleByTitle(String title,Pageable pageable);
    
    @Query("from SafetyArticle s where s.type = ? and s.del=0 order by s.createdate desc")
	Page<SafetyArticle> findSafetyArticleByType(int typeid,Pageable pageable);
    
   
    @Transactional
    @Modifying
    @Query("update SafetyArticle s set s.views = ?  where s.id = ?")
	void updataSafetyArticleById( int i, Long id);

    @Query("from SafetyArticle s where s.columntype = ? and s.del=0 order by s.createdate desc")
	Page<SafetyArticle> findSafetyArticleByColId(int colid, Pageable pageable);


}
