package org.v2ai.dao;

import java.util.List;

import org.v2ai.entity.User;

/**
 * @ClassName: UserDao.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月14日 下午11:56:05
 */
public interface UserDao {

	void register(User u);

	void delete(User u);

	void modity(User u);

	void active(String code, String email);

	User getUser(User u);

	int user_Exist(User u);

	User getUserByUsername(String username);

	User getUserByemail(String email);

	boolean login(User u);

	void logout(User u);

	void addActiveLog(String email,String code);
	
	List executeHQL(String hql);
}
