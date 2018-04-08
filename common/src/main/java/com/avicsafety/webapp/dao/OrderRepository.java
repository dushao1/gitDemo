package com.avicsafety.webapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avicsafety.webapp.entity.Order;
import com.avicsafety.webapp.entity.OrderUser;

@RepositoryRestResource(path="order")
public interface OrderRepository extends JpaRepository<Order, Long> {
	@Override
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Query("from Order u where u.del=0 order by create_date desc")
    Page<Order> findAll(Pageable pageable);
	
	@Query(value="select * from t_order where del = 0 and state = '未受理' and id in (select oid from t_order_user where uid = ?1) order by ?#{#pageable}",
			countQuery = "select count(*) from t_order where del = 0 and state = '未受理' and id in (select oid from t_order_user where uid = ?1)",
			nativeQuery = true)
	Page<Order> findTodoListByUserId(Long uid, Pageable pageable);
	
	@Query("from Order u where u.del = 0 and u.state = ?2 and u.uid = ?1")
	Page<Order> findListByUserIdAndAgreed(Long uid, String state, Pageable pageable);
	
	@Query(value = "select count(*) from t_order where del = 0 and state = '未受理' and id in (select oid from t_order_user where uid = ?1)",
			nativeQuery = true)
	Long countTodoByUserId(Long uid);
	
	Long countByStateAndUidAndDelFalse(String state, Long uid);
	
    @Override
    @RestResource(exported = false)
    void delete(Long id);
    
    @Override
    @RestResource(exported = false)
    void delete(Order m);
    
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
