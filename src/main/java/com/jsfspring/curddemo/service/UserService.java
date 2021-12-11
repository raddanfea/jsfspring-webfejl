
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.UserUITO;

public interface UserService {
	UserUITO doSaveUser(UserUITO userUiTO);

	List<UserUITO> doFetchAllUser();

	UserUITO doGetUser(UserUITO userUiTO);

	void doDeleteUser(UserUITO userUiTO);
}