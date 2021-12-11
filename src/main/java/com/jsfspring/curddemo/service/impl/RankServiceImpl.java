/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.entity.RankDTO;
import com.jsfspring.curddemo.repositry.RankRepo;
import com.jsfspring.curddemo.service.RankService;
import com.jsfspring.curddemo.uito.RankUITO;

@Service
@Transactional
public class RankServiceImpl implements RankService {
	@Autowired
	private RankRepo rankRepo;

	@Override
	public List<RankUITO> getAllRank() {
		List<RankUITO> rankUITOLst = new ArrayList<>();
		List<RankDTO> rankDTOLst = rankRepo.findAll();

		rankDTOLst.forEach(dto -> {
			RankUITO tmpUiTO = new RankUITO();

			BeanUtils.copyProperties(dto, tmpUiTO);
			rankUITOLst.add(tmpUiTO);
		});

		return rankUITOLst;
	}

	@Override
	public RankUITO getRank(RankUITO rankUITO) {
		System.out.println(">>>>> "+ rankUITO.getRankName());
		RankDTO dto = rankRepo.findTitleByRankName(rankUITO.getRankName());
		RankUITO uito = new RankUITO();

		BeanUtils.copyProperties(dto, uito);
		return uito;
	}
}