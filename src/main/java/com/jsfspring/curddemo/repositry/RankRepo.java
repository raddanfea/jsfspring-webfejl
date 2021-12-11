package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.RankDTO;

@Repository
public interface RankRepo extends JpaRepository<RankDTO, Long> {

	RankDTO findTitleByRankName(String deptName);
}