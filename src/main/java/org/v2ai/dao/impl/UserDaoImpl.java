package org.v2ai.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.v2ai.dao.UserDao;
import org.v2ai.entity.User;
import org.v2ai.entity.User_Activate;
import org.v2ai.exception.UserError;

/**
 * @ClassName: UserDaoImpl.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月15日 下午4:13:47
 */

@Repository("UserDaoImpl")
@Transactional
public class UserDaoImpl extends HibernateBasicDaoSupport implements UserDao {

	private User u = new User();

	@Override
	public void register(User u) {
		getCurrentSession().save(u);
	}

	@Override
	public void delete(User u) {
		getCurrentSession().delete(u);
	}

	@Override
	public void modity(User u) {
		getCurrentSession().update(u);
	}

	@Override
	public void active(String code, String email) {
		List<User_Activate> us = getCurrentSession()
				.createCriteria(User_Activate.class)
				.add(Restrictions.eq("activecode", code))
				.add(Restrictions.eq("email", email)).list();
		if (us.size() > 0
				&& (System.currentTimeMillis() - us.get(0).getCreatedate()
						.getTime()) > 20 * 60 * 1000) {
			User u = (User) getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("email", email)).list().get(0);
			u.setIs_active(true);
			getCurrentSession().save(u);
		} else {
			throw new UserError("激活码有误或者已经失效!");
		}
	}

	@Override
	public User getUser(User u) {
		return (User) getCurrentSession().load(User.class, u.getId());
	}

	/***
	 * -1 用户名已经存在 0 邮件已经被注册
	 */
	@Override
	public int user_Exist(User u) {
		int um = getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("username", u.getUsername())).list()
				.size();
		if (um > 0)
			return -1;
		int pw = getCurrentSession().createCriteria(User.class)
				.add(Restrictions.or(Restrictions.eq("email", u.getEmail())))
				.list().size();
		if (pw > 1)
			return 0;
		return 1;
	}

	@Override
	public User getUserByUsername(String username) {
		List<User> ls = getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("username", username)).list();
		return ls.size() > 0 ? ls.get(0) : u;
	}

	@Override
	public User getUserByemail(String email) {
		List<User> ls = getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", email)).list();
		return ls.size() > 0 ? ls.get(0) : u;
	}

	@Override
	public boolean login(User u) {
		return getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", u.getEmail()))
				.add(Restrictions.eq("password", u.getPassword())).list()
				.size() > 0 ? true : false;
	}

	@Override
	public void logout(User u) {

	}

	@Override
	public void addActiveLog(String email, String code) {
		getCurrentSession().save(new User_Activate(email, code));
	}

	@Override
	public List executeHQL(String hql) {
		return getCurrentSession().createQuery(hql).list();
	}

}
