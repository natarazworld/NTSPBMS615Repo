//UserDetails.java
package com.nt.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

import lombok.Data;

@Entity
@Table(name="SECURITY_USERS")
@Data
public class UserDetails {
	@Id
	@GeneratedValue
	private  Integer unid;
	@Column(length = 20,nullable = false,unique = true)
	private  String uname;
	@Column(length = 100,nullable = false)
	private String pwd;
	@Column(length = 20,nullable = false ,unique = true)
	private  String email;
	@Column(length = 1,nullable = false)
	private  Boolean status=true;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="SECURITY_ROLES",joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "UNID"))
	@Column(length = 20,name="ROLE")
	private Set<String> roles;
	
	//setters && gettes
	

	public Integer getUnid() {
		return unid;
	}

	public void setUnid(Integer unid) {
		this.unid = unid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDetails [unid=" + unid + ", uname=" + uname + ", pwd=" + pwd + ", email=" + email + ", status="
				+ status + ", roles=" + roles + "]";
	}
	
	
	
	

}
