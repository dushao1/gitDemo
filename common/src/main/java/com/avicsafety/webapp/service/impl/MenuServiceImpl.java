package com.avicsafety.webapp.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.MenuCateRepository;
import com.avicsafety.webapp.dao.MenuRepository;
import com.avicsafety.webapp.entity.Menu;
import com.avicsafety.webapp.entity.MenuCate;
import com.avicsafety.webapp.entity.Role;
import com.avicsafety.webapp.entity.User;
import com.avicsafety.webapp.service.IMenuService;



@Service
public class MenuServiceImpl implements IMenuService {
	
	private static final Log logger = LogFactory.getLog(MenuServiceImpl.class);
	
	@Autowired
	MenuRepository menu_dao;
	
	@Autowired
	MenuCateRepository menu_cate_dao;

	@Override
	public List<MenuCate> getMenuList() {
		StringBuffer primission = new StringBuffer("");
		//获取当前登录人
		User user = (User) SecurityContextHolder.getContext()  
			    .getAuthentication()  
			    .getPrincipal();
		
		logger.info(user.getUsername());
		
		List<Role> roles = user.getRoles();
		//通过角色列表得到权限编码
		for(Role role:roles) {
			primission.append(role.getPrimission());
		}
		
		List<MenuCate> cate_list = menu_cate_dao.findMenuCate();
		for(int i=cate_list.size()-1;i>=0;i--) {
			if(!primission.toString().contains("MC_"+cate_list.get(i).getId())) {
				cate_list.remove(i);
			}else {
				Set<Menu> menu_list = cate_list.get(i).getMenus();
				Iterator<Menu> it = menu_list.iterator();
				while (it.hasNext()) {
					Menu menu = it.next();
					if(!primission.toString().contains("M_"+menu.getId())) {
						it.remove();
					}
				}
			}
		}
		return cate_list;
	}
}
