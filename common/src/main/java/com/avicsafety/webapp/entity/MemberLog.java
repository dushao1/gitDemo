package com.avicsafety.webapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 会员日志
 * @author Administrator
 *
 */
@Entity
@Table(name="t_member_log")
public class MemberLog {
	
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	/**会员ID*/
	private Long memid = 0L;
    
    /**内容**/
    private String content = "";
    
    /**操作后总积分*/
    private Integer total_score = 0;
    
    /**操作后积分*/
    private Integer score = 0;
    
    /**操作后余额*/
    private Integer money = 0;
    
    /**操作人名称*/
    private String name = "";
	
    /**建立时间**/
    private Date create_date = new Date();
	
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
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

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMemid() {
		return memid;
	}

	public void setMemid(Long memid) {
		this.memid = memid;
	}

	

	
}
