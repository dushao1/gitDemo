package com.avicsafety.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="t_smart_tips")
public class SmartTips {
		/**编号 */
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
	    /**删除标记 */
		private Boolean del = false;
		/**区域id*/
		private String regionGuid; 
		/**类型*/
		private String type; 
	    /**内容*/
		private String content;
		/**最后更新时间*/
		private Date lastChangedDate = new Date();
		/**次数*/
		private int frequency=1;
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
		public String getRegionGuid() {
			return regionGuid;
		}
		public void setRegionGuid(String regionGuid) {
			this.regionGuid = regionGuid;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Date getLastChangedDate() {
			return lastChangedDate;
		}
		public void setLastChangedDate(Date lastChangedDate) {
			this.lastChangedDate = lastChangedDate;
		}
		public int getFrequency() {
			return frequency;
		}
		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}

		

	}

