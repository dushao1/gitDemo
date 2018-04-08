package com.avicsafety.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 小区楼宇
 * @author Administrator
 *
 */
@Entity
@Table(name="t_building")
public class Building {
	
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	/**小区编号 */
	@Column(nullable = false)
    private Long cid;
	
	/**楼宇名称*/
	@Column(nullable = false)
    private String name;
	
	private Integer repair_count = 0;
	
	private Integer install_count = 0;
	
	/**排序*/
	private Integer sort = 0;
	
    /**删除标记 */
	private Boolean del = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
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

	public Integer getRepair_count() {
		return repair_count;
	}

	public void setRepair_count(Integer repair_count) {
		this.repair_count = repair_count;
	}

	public Integer getInstall_count() {
		return install_count;
	}

	public void setInstall_count(Integer install_count) {
		this.install_count = install_count;
	}

	
	
	
}
