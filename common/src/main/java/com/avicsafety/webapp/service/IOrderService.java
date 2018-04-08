package com.avicsafety.webapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.avicsafety.webapp.entity.Order;
import com.avicsafety.webapp.entity.User;

public interface IOrderService {

	Order add(Order order);
	
	/**
	 * 获取指定用户的工单.
	 * @param pageable
	 * @return
	 */
	Page<Order> getTodoListByUser(Pageable pageable, User user);
	
	/**
	 * 获取指定用户的工单.
	 * @param pageable
	 * @return
	 */
	Page<Order> getListByUser(Pageable pageable, User user, String State);
	
	/**
	 * 无法完成的工单
	 * @param id
	 * @param user
	 */
	Order fail(Long id, User user, String cause);
	
	/**
	 * 接受工单
	 * @param id
	 * @param user
	 */
	Order accept(Long id, User user);
	
	/**
	 * 完成工单
	 * @param id
	 * @param user
	 */
	Order finished(Long id, User user);
	
	
	/**
	 * 工单统计
	 */
	Long[] total(User user);
}
