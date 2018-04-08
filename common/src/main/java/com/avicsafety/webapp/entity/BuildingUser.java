package com.avicsafety.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_building_user")
public class BuildingUser {
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	/**类型 */
    private String type;
    
    /**小区号*/
    private Long cid;
    
    /**楼宇编号 */
    private Long bid;
    
    /**用户编号 */
    private Long uid;
    
    /**小区名*/
    private String cname;
    
    /**楼宇名 */
    private String bname;
    
    /**用户名 */
    private String uname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
    
    
}
