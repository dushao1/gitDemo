package com.avicsafety.webapp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avicsafety.webapp.dao.BuildingRepository;
import com.avicsafety.webapp.dao.BuildingUserRepository;
import com.avicsafety.webapp.dao.CommunityRepository;
import com.avicsafety.webapp.dao.OrderRepository;
import com.avicsafety.webapp.dao.OrderUserRepository;
import com.avicsafety.webapp.entity.BuildingUser;
import com.avicsafety.webapp.entity.Order;
import com.avicsafety.webapp.entity.OrderUser;
import com.avicsafety.webapp.entity.User;
import com.avicsafety.webapp.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	CommunityRepository community_dao;
	
	@Autowired
	BuildingRepository building_dao;
	
	@Autowired
	BuildingUserRepository building_user_dao;
	
	@Autowired
	OrderUserRepository order_user_dao;
	
	@Autowired
	OrderRepository order_dao;
	
	@Autowired
	OrderRepository dao;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Order add(Order order) {
		// TODO Auto-generated method stub
		//获取 小区名
		String cname = community_dao.getOne(order.getCid()).getName();
		//获取楼宇名
		String bname = building_dao.getOne(order.getBid()).getName();
		//存储
		order.setCname(cname);
		order.setBname(bname);
		order = dao.save(order);
		
		//从配置表中获取userId
		List<BuildingUser> list = building_user_dao.findByBidAndType(order.getBid(),order.getType());
		
		//写入订单和用户的关联关系
		for(BuildingUser bu : list) {
			OrderUser orderUser = new OrderUser();
			orderUser.setOid(order.getId());
			orderUser.setUid(bu.getUid());
			order_user_dao.save(orderUser);
		}
		
		return order;
	}

	@Override
	public Page<Order> getTodoListByUser(Pageable pageable, User user) {
		// TODO Auto-generated method stub
		Page<Order> list = order_dao.findTodoListByUserId(user.getId(),pageable);
		return list;
	}
	
	@Override
	public Page<Order> getListByUser(Pageable pageable, User user, String state) {
		// TODO Auto-generated method stub
		Page<Order> list = order_dao.findListByUserIdAndAgreed(user.getId(),state,pageable);
		return list;
	}

	@Override
	public Order accept(Long id, User user) {
		// TODO Auto-generated method stub
		Order order  = order_dao.findOne(id);
		order.setUid(user.getId());
		order.setUname(user.getName());
		order.setState("已受理");
		order_dao.save(order);
		return order;
	}
	
	@Override
	public Order fail(Long id, User user, String cause) {
		// TODO Auto-generated method stub
		Order order  = order_dao.findOne(id);
		order.setUid(user.getId());
		order.setUname(user.getName());
		order.setState("未完成");
		order.setCause(cause);
		order_dao.save(order);
		return order;
	}
	
	@Override
	public Order finished(Long id, User user) {
		// TODO Auto-generated method stub
		Order order  = order_dao.findOne(id);
		order.setUid(user.getId());
		order.setUname(user.getName());
		order.setState("已完成");
		order.setFinish_date(new Date());
		order_dao.save(order);
		return order;
	}
	
	@Override
	public Long[] total(User user) {
		// TODO Auto-generated method stub
		Long[] arr = new Long[4];
		arr[0] = order_dao.countTodoByUserId(user.getId());
		arr[1] = order_dao.countByStateAndUidAndDelFalse("已受理",user.getId());
		arr[2] = order_dao.countByStateAndUidAndDelFalse("已完成",user.getId());
		arr[3] = order_dao.countByStateAndUidAndDelFalse("未完成",user.getId());;
		return arr;
	}
	
	

}
