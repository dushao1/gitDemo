package com.avicsafety.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_thumbsup")
public class Thumbsup {
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    /**删除标记 */
	private Boolean del = false;
	/**guid关联safetyArticle的id*/
	private String guid; 
	/**点赞人*/
	private String username;
	/**是否点赞*/
	private Boolean thumbsup = true;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getDel() {
		return del;
	}
	public void setDel(Boolean del) {
		this.del = del;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getThumbsup() {
		return thumbsup;
	}
	public void setThumbsup(Boolean thumbsup) {
		this.thumbsup = thumbsup;
	}
}
