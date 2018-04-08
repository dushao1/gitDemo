package com.avicsafety.webapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.avicsafety.webapp.entity.MenuCate;
import com.avicsafety.webapp.entity.User;
import com.avicsafety.webapp.service.IMenuService;
import com.avicsafety.webapp.service.IUserService;
import com.avicsafety.webapp.utils.HttpUtils;


@RestController
public class MainController {
	
	 @Autowired
	 IUserService UserManager;
	 
	 @Autowired
	 IMenuService MenuManager;

	 @RequestMapping(value="/api/user/me")
	 public User getCurrentUser() {
		 return UserManager.getCurrentUser();
	 }
	 
	 @RequestMapping(value="/api/user/menu")
	 public List<MenuCate> getMenuList() {
		 return MenuManager.getMenuList();
	 }

	 @PostMapping("/api/login")
	 public String login(@RequestBody User user,HttpServletRequest request) {
		 StringBuffer sb = new StringBuffer(request.getScheme());
		 sb.append("://13890999:secret_oas1QAZ@");
		 sb.append(request.getServerName());
		 sb.append(":");
		 sb.append(request.getServerPort());
		 sb.append("/oauth/token?grant_type=password&username=");
		 sb.append(user.getUsername());
		 sb.append("&password=");
		 sb.append(user.getPassword());
		 //String url = "http://13890999:secret@localhost:8080/oauth/token?grant_type=password&username=shili&password=abc123";
		 JSONObject result = JSON.parseObject(HttpUtils.AuthHttpPost(sb.toString()));
		 result.put("timestamp", new Date().getTime());
		 return result.toString();
	 }
}	
