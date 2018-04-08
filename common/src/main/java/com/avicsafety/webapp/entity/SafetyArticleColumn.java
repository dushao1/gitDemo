package com.avicsafety.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_safety_article_column")
public class SafetyArticleColumn {
		/**编号 */
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
	    /**删除标记 */
		private Boolean del = false;
		/**栏目类型*/
		private String col; 
		/**栏目id*/
		private Integer colid; 
		public String getCol() {
			return col;
		}
		public void setCol(String col) {
			this.col = col;
		}
		public Integer getColid() {
			return colid;
		}
		public void setColid(Integer colid) {
			this.colid = colid;
		}
		/**类型*/
		private String type; 
	    /**类型id*/
		private Integer typeid;
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
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Integer getTypeid() {
			return typeid;
		}
		public void setTypeid(Integer typeid) {
			this.typeid = typeid;
		}

	}

