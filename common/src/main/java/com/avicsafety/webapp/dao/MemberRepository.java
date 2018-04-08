package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.Community;
import com.avicsafety.webapp.entity.Member;

@RepositoryRestResource(path="member")
public interface MemberRepository extends JpaRepository<Member, Long> {
	
	Page<Member> findByPhone(@Param("phone") String phone,Pageable pageable);
	
	@RestResource(exported = false)
	List<Member> findByPhone(@Param("phone") String phone);

    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Member m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
