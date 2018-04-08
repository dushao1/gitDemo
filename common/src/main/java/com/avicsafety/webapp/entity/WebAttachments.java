package com.avicsafety.webapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_image")
public class WebAttachments {
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    /**删除标记 */
	private Boolean del = false;
	/**路径*/
	private String path; 
	/**内容*/
	private String content; 
    /**类型*/
	private String type;
	/**创建时间*/
	private Date createdate;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String extension) {
		this.type = extension;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
