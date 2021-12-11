/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.curddemo.service.RankService;
import com.jsfspring.curddemo.service.UserService;
import com.jsfspring.curddemo.uito.RankUITO;
import com.jsfspring.curddemo.uito.UserUITO;

@Controller("usrController")
@SessionScope
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private RankService rankService;

	private String actionLabel;
	private UserUITO usrUiTO;
	private List<UserUITO> usrUiToList;

	private List<RankUITO> rankUiToList;

	/**
	 * add or update new Record in DB
	 * 
	 * @return
	 */
	public void doSaveInfoUsr() {
		System.out.println(this.getUsrUiTO());
		userService.doSaveUser(this.getUsrUiTO());
		getAllUsr();
		this.setUsrUiTO(new UserUITO());
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"User Details", "User Details added/Updated Successfully."));

	}

	/**
	 * Default load all the User info
	 */
	@PostConstruct
	public void getAllUsr() {
		if (!this.getUsrUiToList().isEmpty()) {
			this.getUsrUiToList().clear();
			this.getRankUiToList().clear();
		}
		System.out.println(" >>>>>>>>>>>>> " + userService);
		this.getUsrUiToList().addAll(userService.doFetchAllUser());
		this.getRankUiToList().addAll(rankService.getAllRank());
		this.setActionLabel("Add");
	}

	/**
	 * Remove selected User info
	 * 
	 * @return
	 */

	public void deleteUser(UserUITO userUITO) {
		userService.doDeleteUser(userUITO);
		getAllUsr();
	}

	public void editUser(UserUITO userUiTO) {
		this.setActionLabel("Update");
		BeanUtils.copyProperties(userUiTO, this.getUsrUiTO());
		System.out.println(this.getUsrUiTO());
	}

	public UserUITO getUsrUiTO() {
		if (usrUiTO == null) {
			usrUiTO = new UserUITO();
		}
		return usrUiTO;
	}

	public void setUsrUiTO(UserUITO usrUiTO) {
		this.usrUiTO = usrUiTO;
	}

	public List<UserUITO> getUsrUiToList() {
		if (null == usrUiToList) {
			usrUiToList = new ArrayList<>();
		}
		return usrUiToList;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public List<RankUITO> getRankUiToList() {
		if (rankUiToList == null) {
			rankUiToList = new ArrayList<>();
		}
		return rankUiToList;
	}

	public void setRankUiToList(List<RankUITO> rankUiToList) {
		this.rankUiToList = rankUiToList;
	}
}