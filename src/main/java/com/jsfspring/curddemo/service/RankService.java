
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.RankUITO;

public interface RankService {

	List<RankUITO> getAllRank();

	RankUITO getRank(RankUITO rankUITO);

}