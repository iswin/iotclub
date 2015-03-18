package org.v2ai.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.v2ai.dao.TopicDao;
import org.v2ai.entity.Topic;
import org.v2ai.entity.User_Collection_Topic;

/**
 * @ClassName: TopicDaoImpl.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月17日 上午12:14:03
 */
public class TopicDaoImpl extends HibernateBasicDaoSupport implements TopicDao {

	@Override
	public void add(Topic top) {
		getCurrentSession().save(top);
	}

	@Override
	public void delete(int topicid, int userid) {
		// 删除时对于多用户来说，必须检查当前该主题是不是属于当前用户所有，否则容易产生越权操作
		if (is_topicBelongsToCurrentUser(topicid, userid)) {
			getCurrentSession().delete(
					getCurrentSession().load(Topic.class, topicid));
		}
	}

	@Override
	public void modify(Topic tp, int userid) {
		if (is_topicBelongsToCurrentUser(tp.getId(), userid)) {
			getCurrentSession().save(tp);
		}
	}

	@Override
	public void userCollect(int topicid, int userid) {
		getCurrentSession().save(new User_Collection_Topic(userid, topicid));
	}

	@Override
	public boolean is_topicBelongsToCurrentUser(int topicid, int userid) {
		return getCurrentSession().createCriteria(Topic.class)
				.add(Restrictions.eq("userid", userid))
				.add(Restrictions.eq("id", topicid)).list().size() > 0 ? true
				: false;
	}

}
