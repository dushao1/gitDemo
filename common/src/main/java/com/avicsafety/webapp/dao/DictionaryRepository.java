package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.Dictionary;

@RepositoryRestResource(path="dictionary")
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
	
	List<Dictionary> findByTypeAndDelFalseOrderBySortAsc(@Param("type") String type);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Dictionary m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
