package com.avicsafety.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.MemberLogRepository;
import com.avicsafety.webapp.dao.MemberPrizeRepository;
import com.avicsafety.webapp.dao.MemberRepository;
import com.avicsafety.webapp.entity.Member;
import com.avicsafety.webapp.entity.MemberLog;
import com.avicsafety.webapp.entity.MemberPrize;
import com.avicsafety.webapp.entity.User;
import com.avicsafety.webapp.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	MemberPrizeRepository prize_dao;
	
	@Autowired
	MemberLogRepository log_dao;
	
	@Autowired
	MemberRepository dao;

	@Override
	public void addMoney(Integer value, Long memid, User user) {
		// TODO Auto-generated method stub
		Member member = dao.findOne(memid);
		member.setMoney(member.getMoney()+value);
		dao.save(member);
		addMemberLog("ADD_MONEY",member,null,0,member.getName(),member.getScore(),member.getMoney(),user.getName());
	}


	@Override
	public void addScore(Integer value, Long memid, User user) {
		// TODO Auto-generated method stub
		Member member = dao.findOne(memid);
		member.setScore(member.getScore()+value);
		dao.save(member);
		addMemberLog("ADD_SCORE",member,null,0,member.getName(),member.getScore(),member.getMoney(),user.getName());
	}

	@Override
	public Boolean useScore(Long prize_id, Long memid, User user) {
		// TODO Auto-generated method stub
		MemberPrize prize = prize_dao.findOne(prize_id);
		Integer value = prize.getScore();
		Member member = dao.findOne(memid);
		Integer score = member.getScore();
		if(score>=value) {
			member.setScore(score-value);
			dao.save(member);
			addMemberLog("USE_SCORE",member,prize.getName(),value,member.getName(),member.getScore(),member.getMoney(),user.getName());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean useMoney(Integer value, Long memid, User user) {

		Member member = dao.findOne(memid);
		Integer money = member.getMoney();
		if(money>=value) {
			member.setMoney(money-value);
			member = dao.save(member);
			addMemberLog("USE_MONEY",member,null,value,member.getName(),member.getScore(),member.getMoney(),user.getName());
			return true;
		}else {
			return false;
		}
		
	}


	@Override
	public Member addMember(Member member, User user) {
		//保存
		member = dao.save(member);
		addMemberLog("ADD_MEMBER",member,null, 0,member.getName(),member.getScore(),member.getMoney(),user.getName());
		//记录
		return member;
	}
	
	public void addMemberLog(String action,Member member, String prizename, Integer value, String member_name, Integer score, Integer money, String user_name) {
		MemberLog log = new MemberLog();
		if(action.equals("ADD_MEMBER")) {
			StringBuffer content = new StringBuffer("新会员");
			content.append(member_name);
			content.append("加入,初始积分:");
			content.append(score);
			content.append(",余额:");
			content.append(money);
			log.setContent(content.toString());
		}else if(action.equals("USE_MONEY")) {
			StringBuffer content = new StringBuffer("会员消费");
			content.append(value);
			content.append("元");
			log.setContent(content.toString());
		}else if(action.equals("USE_SCORE")) {
			StringBuffer content = new StringBuffer("兑换");
			content.append(prizename);
			content.append(",消耗积分");
			content.append(value);
			content.append("点");
			log.setContent(content.toString());
		}else if(action.equals("ADD_SCORE")) {
			StringBuffer content = new StringBuffer("增加积分");
			content.append(value);
			content.append("点");
			log.setContent(content.toString());
		}else if(action.equals("ADD_MONEY")) {
			StringBuffer content = new StringBuffer("充值");
			content.append(value);
			content.append("元");
			log.setContent(content.toString());
		}
		log.setMemid(member.getId());
		log.setTotal_score(score);
		log.setScore(score);
		log.setMoney(money);
		log.setName(user_name);
		//记录
		log_dao.save(log);
	}


	@Override
	public Member findMemberByPhone(String phone) {
		List<Member> list = dao.findByPhone(phone);
		if(list==null||list.size()==0) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public Page<MemberLog> findMemberLogByMemberId(Long memid, Pageable pageable) {
		// TODO Auto-generated method stub
		Page<MemberLog> list = log_dao.findByMemid(memid, pageable);
		return list;
	}

}
