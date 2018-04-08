package com.avicsafety.webapp.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@SuppressWarnings("serial")
@Entity
@Table(name="t_user")
public class User implements UserDetails {
	
	/**编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**姓名*/
	@Column(unique = true, nullable = false)
    private String name;
	
	/**电话*/
	@Column(nullable = false)
    private String phone = "";

    /**用户名 */
    @Column(unique = true, nullable = false)
    private String username;

    /**密码 */
    //@JsonIgnore
    @Column(nullable = false)
    private String password;
    
    /**登录次数*/
	private Integer login_count = 0;
    
    /**最后登录地址*/
	private String last_login_ip = "";
    
    /**最后登录时间*/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date last_login_date = new Date();
    
    /**建立时间*/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_date = new Date();
    
    /**排序 */
    private Integer sort = 0;
    
    /**锁定 */
    private Integer locked = 0;
    
    /**是否关闭 */
	private Integer disable = 0;
    
    /**删除标记 */
	private Boolean del = false;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(name = "rong_user_role", joinColumns = { @JoinColumn(name ="user_id" )}, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    @OrderBy("id")
	private List<Role> roles = new ArrayList<Role>();    //角色集合

	@JsonIgnore
	@Transient
	List<GrantedAuthority> list = new ArrayList<GrantedAuthority>(); 
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLogin_count() {
		return login_count;
	}

	public void setLogin_count(Integer login_count) {
		this.login_count = login_count;
	}

	public Date getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public Integer getDisable() {
		return disable;
	}

	public void setDnabled(Integer disable) {
		this.disable = disable;
	}
   
	@JsonIgnore
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> list = new ArrayList<>();
		List<Role> roles = getRoles();
		for(Role role : roles) {
			list.add(new SimpleGrantedAuthority(role.getValue()));
		}
        return list;  
	}
	
	@JsonIgnore
	public void setAuthorities(List<GrantedAuthority> list) {
		this.list = list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return locked==0;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return disable==0;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

	public void setDisable(Integer disable) {
		this.disable = disable;
	}

	
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public List<GrantedAuthority> getList() {
		return list;
	}

	public void setList(List<GrantedAuthority> list) {
		this.list = list;
	}
    
    
    
}
