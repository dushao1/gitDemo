package com.avicsafety.webapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**工单*/
@Entity
@Table(name="t_order")
public class Order {
	
	/**编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	/**行政区*/
	@Column(nullable = false)
	private String district;
	
	/**小区编号*/
	@Column(nullable = false)
    private Long cid;
	
	/**小区名称*/
	@Column(nullable = false)
    private String cname;
	
	/**楼宇编号*/
    private Long bid;
		
	/**楼宇名*/
    private String bname;
    
    /**地址 这里存储 1-1-1 这种*/
    private String addr;
    
    /**客户姓名*/
    private String client_name;
    
    /**客户联系电话*/
    private String client_tel;
    
    /**订单类型  包含:安装, 维修*/
    @Column(nullable = false)
    private String type;
    
    /**订单状态  包含:未受理, 已受理, 已完成, 未完成*/
    @Column(nullable = false)
    private String state = "未受理";
    
    /**受理人编号*/
    private Long uid;
    
    /**受理人名*/
    private String uname;
    
    /**未完成原因  包含:未领取设备 电视老旧  线路老化 缺少配件 家中无人*/
    private String cause = "";
    
    /**描述*/
    private String ms = "";
	
	/**建立时间*/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_date = new Date();
    
    /**完成时间*/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date finish_date = new Date();
    
    /**删除 */
    private Boolean del = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_tel() {
		return client_tel;
	}

	public void setClient_tel(String client_tel) {
		this.client_tel = client_tel;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
    
    
}
