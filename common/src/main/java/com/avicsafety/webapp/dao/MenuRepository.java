package com.avicsafety.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.avicsafety.webapp.entity.Menu;

@RepositoryRestResource(path="menu")
public interface MenuRepository extends JpaRepository<Menu, Long> {
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from Menu u where u.del=0 order by sort")
    Page<Menu> findAll(Pageable pageable);
	
	@Query("from Menu u where u.del=0 and u.cid = :cid order by sort")
    Page<Menu> findByCid(@Param("cid") Long cid, Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Menu cate);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
