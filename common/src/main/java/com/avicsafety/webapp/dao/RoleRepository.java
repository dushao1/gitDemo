package com.avicsafety.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.Role;

@RepositoryRestResource(path="role")
public interface RoleRepository extends JpaRepository<Role, Long> {
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from Role u where u.del=0 order by sort")
    Page<Role> findAll(Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Role m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
