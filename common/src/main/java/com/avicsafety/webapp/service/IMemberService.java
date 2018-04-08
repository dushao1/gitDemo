package com.avicsafety.webapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.avicsafety.webapp.entity.Member;
import com.avicsafety.webapp.entity.MemberLog;
import com.avicsafety.webapp.entity.User;

public interface IMemberService {
	
	/** 新建会员 */
	Member addMember(Member member, User user); 
	
	/**
	 * 消费
	 * @param value
	 * @param memid
	 */
	void addMoney(Integer value, Long memid, User user);
	
	/**充值
	 * 
	 * @param value
	 * @param memid
	 * @return
	 */
	Boolean useMoney(Integer value, Long memid, User user);
	
	/**
	 * 增加积分
	 * @param value
	 * @param memid
	 */
	void addScore(Integer value, Long memid, User user);
	
	/**使用积分
	 * 
	 * @param value
	 * @param memid
	 * @return
	 */
	Boolean useScore(Long value, Long memid, User user);
	
	/**
	 * 通过电话搜搜会员
	 */
	Member findMemberByPhone(String phone);

	/**
	 * 通过会员编号 获得 会员日志信息
	 * @param memid
	 * @return
	 */
	Page<MemberLog> findMemberLogByMemberId(Long memid, Pageable pageable);
}
