package com.jsfspring.curddemo.utills;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfspring.curddemo.service.RankService;
import com.jsfspring.curddemo.uito.RankUITO;

@Service
public class RankConverter implements Converter {

	@Autowired
	private RankService departmentService;

	private static final Logger LOG = LoggerFactory.getLogger(RankConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		LOG.info("getAsObject: " + departmentService);

		RankUITO rankUITO = new RankUITO();
		rankUITO.setRankName(string);
		rankUITO = departmentService.getRank(rankUITO);
		System.out.println(rankUITO.toString());
		return rankUITO;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		LOG.info("getAsString obj class: " + obj.getClass().getName());
		if (obj instanceof RankUITO) {
			RankUITO rank = (RankUITO) obj;
			LOG.info("getAsString def name: " + rank.getRankName());
			return rank.getRankName();
		} else {
			StringBuilder sbError = new StringBuilder("The object of class ");
			sbError.append(obj.getClass().getName()).append(" is not of DepartmentUITO");
			throw new ClassCastException(sbError.toString());
		}
	}
}