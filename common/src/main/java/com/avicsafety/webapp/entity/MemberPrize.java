package com.avicsafety.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_member_prize")
public class MemberPrize {
	
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	/**奖品名称*/
	@Column(nullable = false)
    private String name;
	
	/**所需积分*/
	@Column(nullable = false)
    private Integer score;
	
	/**排序*/
	private Integer sort = 0;
	
	/**删除*/
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	
	
	
}
