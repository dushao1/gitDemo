package com.avicsafety.webapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name="t_menu_cate")
public class MenuCate {
	
	/**编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**菜单分类名*/
	@Column(nullable = false)
    private String name;
	
	/**排序**/
	private Integer sort = 0;
	
	/**删除*/
	private Boolean del = false;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="cid")
	@OrderBy("sort")
	@Where(clause="del=0")
	private Set<Menu> menus = new HashSet<Menu>();
   
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
    
}
