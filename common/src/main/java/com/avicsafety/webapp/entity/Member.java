package com.avicsafety.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 会员表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_member")
public class Member {
	
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	/**会员微信号 */
    private String wx = "";
	
	/**会员电话*/
	@Column(nullable = false)
    private String phone;
	
	/**会员名称*/
	@Column(nullable = false)
    private String name;
	
	/**会员性别 1男 0女 -1保密 2...*/
    private Integer sex = -1;
    
    /**会员地址**/
    private String address = "";
	
	/**总积分**/
	private Integer total_score = 0;
	
	/**当前积分*/
	private Integer score = 0;
	
	/**充值*/
	private Integer money = 0;
	
    /**删除标记 */
	private Boolean del = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWx() {
		return wx;
	}

	public void setWx(String wx) {
		this.wx = wx;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTotal_score() {
		return total_score;
	}

	public void setTotal_score(Integer total_score) {
		this.total_score = total_score;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	
	
}
