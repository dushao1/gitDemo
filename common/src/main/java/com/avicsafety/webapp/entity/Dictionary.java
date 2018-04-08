package com.avicsafety.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**字典*/
@Entity
@Table(name="t_dictionary")
public class Dictionary {

	/**编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**类型*/
	@Column(nullable = false)
    private String type;
    
    /**值*/
	@Column(nullable = false)
    private String value;
    
    /**名*/
	@Column(nullable = false)
    private String name;
	
	/**描述*/
    private String ms = "";
	
	/**排序*/
    private Integer sort = 0;
	
	/**删除*/
    private Boolean del = false ;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
    
    
}
