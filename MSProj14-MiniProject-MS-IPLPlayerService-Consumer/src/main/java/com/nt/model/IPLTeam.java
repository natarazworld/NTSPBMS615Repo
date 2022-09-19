//IPLTeam.java
package com.nt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MS_IPLTeam")
public class IPLTeam implements Serializable{
	@Id
	@GeneratedValue
	private  Integer teamId;
	@Column(length = 20)
	private  String  teamName;
	@Column(length = 20)
	private  String owner;
	@Column(length = 20)
	private  String captain;
	
	
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	
	

	@Override
	public String toString() {
		return "IPLTeam [teamId=" + teamId + ", teamName=" + teamName + ", owner=" + owner + ", captain=" + captain
				+ "]";
	}
	
	
	
	

}
