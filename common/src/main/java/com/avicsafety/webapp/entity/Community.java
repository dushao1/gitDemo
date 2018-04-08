package com.avicsafety.webapp.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 小区表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_community")
public class Community {
	
	/**编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**行政区*/
	@Column(nullable = false)
    private String district;
    
    /**小区名*/
	@Column(unique = true, nullable = false)
    private String name;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="cid")
	private List<Building> buildings = new ArrayList<Building>();
	
	/**排序 */
    private Integer sort = 0;
    
    /**删除标记 */
	private Boolean del = false;

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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	
	
}
