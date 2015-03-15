package org.v2ai.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: HibernateBasicDao.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月15日 下午1:30:19
 */
@Component
@Transactional
public class HibernateBasicDaoSupport {

	public Session sessionTemplate;
	@Resource
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
