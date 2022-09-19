//IPLPlayer.java
package com.nt.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MS_IPLPLAYER")
public class IPLPlayer implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "pid_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer playerId;
	@Column(length = 20)
	private  String    playerName;
	private   Integer  jersyNo;
	@Column(length = 20)
	private  String category;
	@ManyToOne(targetEntity = IPLTeam.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name="team_uid",referencedColumnName = "teamid")
	private  IPLTeam teamInfo;
	

	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Integer getJersyNo() {
		return jersyNo;
	}
	public void setJersyNo(Integer jersyNo) {
		this.jersyNo = jersyNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public IPLTeam getTeamInfo() {
		return teamInfo;
	}
	public void setTeamInfo(IPLTeam teamInfo) {
		this.teamInfo = teamInfo;
	}
	
	@Override
	public String toString() {
		return "IPLPlayer [playerId=" + playerId + ", playerName=" + playerName + ", jersyNo=" + jersyNo + ", category="
				+ category + "]";
	}
	

}
