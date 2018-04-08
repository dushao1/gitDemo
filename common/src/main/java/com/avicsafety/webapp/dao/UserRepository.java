package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.avicsafety.webapp.entity.User;


@RepositoryRestResource(path="user")
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {
	
	@RestResource(exported = false)
    List<User> findByUsernameAndDelFalse(String username);
	
	//http://localhost:8080/api/role/1/user
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(User m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    @Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from User u where u.del=0 order by sort")
    Page<User> findAll(Pageable pageable);
}