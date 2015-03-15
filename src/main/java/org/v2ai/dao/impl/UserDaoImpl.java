package org.v2ai.dao.impl;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.v2ai.dao.UserDao;
import org.v2ai.entity.User_Activate;
import org.v2ai.entity.User;

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

	@Override
	public void register(User u) {
	}

	@Override
	public void delete(User u) {

	}

	@Override
	public void modity(User u) {

	}

	@Override
	public void active(String code) {
		List<User_Activate> us = getCurrentSession()
				.createCriteria(User_Activate.class)
				.add(Restrictions.eq("activecode", code)).list();
		if (us.size() > 0
				&& (System.currentTimeMillis() - us.get(0).getCreatedate()
						.getTime()) > 20 * 60 * 1000) {
			User u = (User) getCurrentSession().load(User.class,
					us.get(0).getUserid());
			u.setIs_active(true);
			getCurrentSession().save(u);
		} else {
			throw new UnknownError("激活码有误或者已经失效!");
		}
	}

	@Override
	public User getUser(User u) {
		return null;
	}

}
