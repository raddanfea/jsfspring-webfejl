package com.jsfspring.curddemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "RANKS")
public class RankDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RANK_ID")
	private Long rankId;
	@Column(name = "Rank_Name")
	private String rankName;

	@OneToMany(mappedBy = "rankDTO")
	private List<UserDTO> userdtolst;

	public Long getRankId() {
		return rankId;
	}

	public void setRankId(Long rankId) {
		this.rankId = rankId;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public List<UserDTO> getUserdtolst() {
		if (null == userdtolst) {
			userdtolst = new ArrayList<>();
		}
		return userdtolst;
	}

	public void setUserdtolst(List<UserDTO> userdtolst) {
		this.userdtolst = userdtolst;
	}
}
