package com.avicsafety.webapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.Member;
import com.avicsafety.webapp.entity.MemberLevel;
import com.avicsafety.webapp.entity.MemberPrize;

@RepositoryRestResource(path="member_prize")
public interface MemberPrizeRepository extends JpaRepository<MemberPrize, Long> {

    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(MemberPrize m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
