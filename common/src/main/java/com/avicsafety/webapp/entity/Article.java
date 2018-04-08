package com.avicsafety.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_article")
public class Article {
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
	    /**类型*/
		private Integer type;
		public Integer getType() {
			return type;
		}
		public void setType(Integer type) {
			this.type = type;
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
		
		

	}

