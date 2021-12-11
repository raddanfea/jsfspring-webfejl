package com.jsfspring.curddemo.uito;

import java.io.Serializable;
import java.util.List;

public class RankUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long rankId;
	private String rankName;

	private List<UserUITO> userUITOLst;

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

	public List<UserUITO> getUserUITOLst() {
		return userUITOLst;
	}

	public void setUserUITOLst(List<UserUITO> userUITOLst) {
		this.userUITOLst = userUITOLst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rankId == null) ? 0 : rankId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RankUITO other = (RankUITO) obj;
		if (rankId == null) {
			if (other.rankId != null)
				return false;
		} else if (!rankId.equals(other.rankId))
			return false;
		return true;
	}

}
