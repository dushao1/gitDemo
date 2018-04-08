package com.avicsafety.webapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.avicsafety.webapp.entity.OrderUser;

/**关联关系*/
@RepositoryRestResource(path="order_user")
public interface OrderUserRepository extends JpaRepository<OrderUser, Long> {


}
