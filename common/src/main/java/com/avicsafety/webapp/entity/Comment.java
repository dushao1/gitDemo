package com.avicsafety.webapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_comment")
public class Comment {
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    /**删除标记 */
	private Boolean del = false;
	/**创建人*/
	private String createtor; 
	/**内容*/
	private String content; 
	/**guid关联safetyArticle的id*/
	private String guid; 
	/**创建时间*/
	private Date createdate = new Date();
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
	public String getCreatetor() {
		return createtor;
	}
	public void setCreatetor(String createtor) {
		this.createtor = createtor;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
}
