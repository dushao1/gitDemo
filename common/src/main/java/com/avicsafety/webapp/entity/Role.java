package com.avicsafety.webapp.entity;


import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="t_role")
public class Role {
	/**编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**角色名称*/
	@Column(unique = true, nullable = false)
    private String name;
	
	/**角色码*/
	@Column(unique = true, nullable = false)
    private String value;
	
	/**默认页*/
	private String defaultPage = "";
	
	/**删除标记 */
	private String primission = "";
	
	/**排序 */
    private Integer sort = 0;
    
    /**删除标记 */
	private Integer del = 0;

	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "roles", fetch = FetchType.EAGER)
	private Set<User> user = new LinkedHashSet<User>();  
	
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPrimission() {
		return primission;
	}

	public void setPrimission(String primission) {
		this.primission = primission;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	
    public Set<User> getUser() {
        return user;
    }
    public void setUser(Set<User> user) {
        this.user = user;
    }

	public String getDefaultPage() {
		return defaultPage;
	}

	public void setDefaultPage(String defaultPage) {
		this.defaultPage = defaultPage;
	}



	
	
}
