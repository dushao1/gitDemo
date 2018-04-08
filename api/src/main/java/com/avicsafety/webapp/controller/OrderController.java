package com.avicsafety.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.entity.Order;
import com.avicsafety.webapp.service.IOrderService;
import com.avicsafety.webapp.service.IUserService;



@RestController
public class OrderController {
	
	 @Autowired
	 IUserService UserManager;
	
	 @Autowired
	 IOrderService OrderManager;
	
	 @RequestMapping(value="/api/order/add")
	 public Order add(@RequestBody Order order) {
		 return OrderManager.add(order);
	 }
	 
	 @RequestMapping(value="/api/order/todo")
	 public Page<Order> getTodoListByUser(Pageable pageable) {
		 return OrderManager.getTodoListByUser(pageable, UserManager.getCurrentUser());
	 }
	 
	 @RequestMapping(value="/api/order/mine")
	 public Page<Order> getListByMySelf(Pageable pageable) {
		 return OrderManager.getListByUser(pageable, UserManager.getCurrentUser(), "已受理");
	 }
	 
	 @RequestMapping(value="/api/order/finished")
	 public Page<Order> getListByFinished(Pageable pageable) {
		 return OrderManager.getListByUser(pageable, UserManager.getCurrentUser(), "已完成");
	 }
	 
	 @RequestMapping(value="/api/order/unfinished")
	 public Page<Order> getListByUnfinished(Pageable pageable) {
		 return OrderManager.getListByUser(pageable, UserManager.getCurrentUser(), "未完成");
	 }
	 
	 @RequestMapping(value="/api/order/onAccept")
	 public Order accept(@RequestParam("id") Long id) {
		 return OrderManager.accept(id,UserManager.getCurrentUser());
	 }
	 
	 @RequestMapping(value="/api/order/onFail")
	 public Order fail(@RequestParam("id") Long id,@RequestParam("cause") String cause) {
		 return OrderManager.fail(id,UserManager.getCurrentUser(),cause);
	 }
	 
	 @RequestMapping(value="/api/order/onFinished")
	 public Order finished(@RequestParam("id") Long id) {
		 return OrderManager.finished(id,UserManager.getCurrentUser());
	 }
	 
	 @RequestMapping(value="/api/order/total")
	 public Long[] total() {
		 return OrderManager.total(UserManager.getCurrentUser());
	 }
	 
}
