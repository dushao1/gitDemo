package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.MenuCate;

@RepositoryRestResource(path="menu_cate",excerptProjection=MenuCateOutput.class)
public interface MenuCateRepository extends JpaRepository<MenuCate, Long> {
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from MenuCate u where u.del=0 order by sort")
    Page<MenuCate> findAll(Pageable pageable);
		
	@Query("from MenuCate u where u.del=0 order by sort")
	List<MenuCate> findMenuCate();
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(MenuCate m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
