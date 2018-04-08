package com.avicsafety.webapp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import com.avicsafety.webapp.entity.SmartTips;

@RepositoryRestResource(path="SmartTips")
public interface SmartTipsRepository extends JpaRepository<SmartTips, Long>{
   
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from SmartTips u where u.del=0")
    Page<SmartTips> findAll(Pageable pageable);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(SmartTips m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
    
    @Query("from SmartTips s where s.regionGuid = ? and s.type = ? and s.del=0 order by s.frequency desc,s.lastChangedDate desc")
	Page<SmartTips> findSmartTipsByType(String regionGuid, String type,Pageable pageable);
    
    @Query("from SmartTips s where s.del=0 and s.type = ? and s.content = ? and s.regionGuid = ?")
	SmartTips findOneByTypeAndContent(String type, String content, String regionGuid);
   
    @Transactional
    @Modifying
    @Query("update SmartTips s set s.frequency = ? , s.lastChangedDate = ? where s.id = ?")
	void updataSmartTipsById( int i,Date date, Long id);


}
