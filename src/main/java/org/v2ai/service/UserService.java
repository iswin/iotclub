package org.v2ai.service;

import org.v2ai.entity.Result;
import org.v2ai.entity.User;

/**
 * @ClassName: UserService.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月16日 上午12:26:16
 */
public interface UserService {

	Result register(User u);

	void modify(User u);

	void delete(User u);

	boolean login(User u);

	boolean logout(User u);

	void userActive(String code);

	User getUser(User u);

	int user_Exist(User u);

	User getUserByUsername(String username);

	User getUserByemail(String email);
}
