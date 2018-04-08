package com.avicsafety.webapp.dao;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.avicsafety.webapp.entity.Menu;
import com.avicsafety.webapp.entity.MenuCate;

@Projection(name = "myMenuCateOutput", types = { MenuCate.class }) 
public interface MenuCateOutput {
	Long getId();
	String getName();
	Integer getSort();
	Set<Menu> getMenus(); 
}
