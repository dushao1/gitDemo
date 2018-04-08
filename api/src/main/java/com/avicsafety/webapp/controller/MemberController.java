package com.avicsafety.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.entity.Member;
import com.avicsafety.webapp.entity.MemberLog;
import com.avicsafety.webapp.entity.User;
import com.avicsafety.webapp.service.IMemberService;



@RestController
public class MemberController {
	
	 @Autowired
	 IMemberService MemberManager;
	 
	 @PostMapping(value="/api/member/addMember")
	 public String addMember(@RequestBody Member member) {
		 User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 MemberManager.addMember(member, user);
		 return "success";
	 }
	
	 @RequestMapping(value="/api/member/addScore")
	 public String addScore(@RequestParam("value") Integer value,@RequestParam("memid") Long memid) {
		 User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 MemberManager.addScore(value,memid,user);
		 return "success";
	 }
	 
	 @RequestMapping(value="/api/member/addMoney")
	 public String addMoney(@RequestParam("value") Integer value,@RequestParam("memid") Long memid) {
		 User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 MemberManager.addMoney(value,memid,user);
		 return "success";
	 }
	 
	 @RequestMapping(value="/api/member/useScore")
	 public String useScore(@RequestParam("value") Long prize_id,@RequestParam("memid") Long memid) {
		 User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 Boolean result = MemberManager.useScore(prize_id,memid,user);
		 if(result) {
			 return "success";
		 }else {
			 return "fail";
		 }
	 }
	 
	 @RequestMapping(value="/api/member/useMoney")
	 public String useMoney(@RequestParam("value") Integer value,@RequestParam("memid") Long memid) {
		 User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 Boolean result = MemberManager.useMoney(value,memid,user);
		 if(result) {
			 return "success";
		 }else {
			 return "fail";
		 } 
	 }
	 
	 @RequestMapping(value="/api/public/findMemberByPhone")
	 public Member findMemberByPhone(@RequestParam("phone") String phone) {
		 return MemberManager.findMemberByPhone(phone);
	 }
	 
	 @RequestMapping(value="/api/public/findMemberLogByMemberId")
	 public Page<MemberLog> findMemberLogByMemberId(@RequestParam("id") Long memid, Pageable pageable) {
		 return MemberManager.findMemberLogByMemberId(memid, pageable);
	 }
}
