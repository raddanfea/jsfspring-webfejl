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
import com.jsfspring.curddemo.entity.UserDTO;
import com.jsfspring.curddemo.repositry.UserRepo;
import com.jsfspring.curddemo.service.UserService;
import com.jsfspring.curddemo.uito.RankUITO;
import com.jsfspring.curddemo.uito.UserUITO;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;

	@Override
	@Transactional(readOnly = false)
	public UserUITO doSaveUser(UserUITO userUiTO) {
		UserDTO dto = UiToToDto(userUiTO);
		dto = userRepo.save(dto);
		BeanUtils.copyProperties(dto, userUiTO);

		dtoToUito(userUiTO, dto);
		return userUiTO;
	}

	private void dtoToUito(UserUITO userUiTO, UserDTO dto) {
		RankUITO uitTO = new RankUITO();
		BeanUtils.copyProperties(dto.getRankDTO(), uitTO);
		userUiTO.setRankUITO(uitTO);
	}

	private UserDTO UiToToDto(UserUITO userUITO) {
		UserDTO dto = new UserDTO();
		RankDTO rankDto = new RankDTO();
		BeanUtils.copyProperties(userUITO, dto);
		BeanUtils.copyProperties(userUITO.getRankUITO(), rankDto);
		dto.setRankDTO(rankDto);
		List<UserDTO> lst = new ArrayList<>();
		lst.add(dto);
		rankDto.getUserdtolst().addAll(lst);
		return dto;
	}

	@Override
	public List<UserUITO> doFetchAllUser() {
		List<UserDTO> dtoLst = userRepo.findAll();
		List<UserUITO> uiTOLst = new ArrayList<>();
		dtoLst.forEach(dto -> {
			UserUITO tmpUiTO = new UserUITO();
			System.out.println(dto.getRankDTO());
			BeanUtils.copyProperties(dto, tmpUiTO);
			dtoToUito(tmpUiTO, dto);
			uiTOLst.add(tmpUiTO);
		});
		return uiTOLst;
	}

	@Override
	public UserUITO doGetUser(UserUITO userUiTO) {
		if (null != userUiTO.getEmailId()) {
			UserDTO dto = new UserDTO();

			BeanUtils.copyProperties(userUiTO, dto);
			dto = userRepo.getOne(dto.getUserId());

			BeanUtils.copyProperties(dto, userUiTO);
		}
		return userUiTO;
	}

	@Override
	@Transactional
	public void doDeleteUser(UserUITO userUiTO) {

		userRepo.deleteById(userUiTO.getUserId());
	}

}