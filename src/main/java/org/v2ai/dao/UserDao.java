package org.v2ai.dao;

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

	void active(String code);

	User getUser(User u);
}
