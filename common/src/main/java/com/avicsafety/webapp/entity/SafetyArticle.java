package com.avicsafety.webapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_safety_article")
public class SafetyArticle {
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    /**删除标记 */
	private Boolean del = false;
	/**标题*/
	private String title; 
	/**内容*/
	private String content;
	/**缩略图*/
	private String thumbnail; 
	/**栏目类型*/
	private Integer columntype;
    /**子类型*/
	private Integer type;
	/**浏览次数*/
	private Integer views = 0;
    /**标签*/
	private String tag;
	/**发布时间*/
	private Date createdate = new Date();
	/**点赞次数*/
	private Integer thumbsup = 0;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Integer getColumntype() {
		return columntype;
	}
	public void setColumntype(Integer columntype) {
		this.columntype = columntype;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Integer getThumbsup() {
		return thumbsup;
	}
	public void setThumbsup(Integer thumbsup) {
		this.thumbsup = thumbsup;
	}
}
