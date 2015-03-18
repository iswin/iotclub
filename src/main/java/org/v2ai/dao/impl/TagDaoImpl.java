package org.v2ai.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.v2ai.dao.TagDao;
import org.v2ai.entity.Tag;
import org.v2ai.entity.Topic;

/**
 * @ClassName: TagDaoImpl.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月14日 下午11:57:40
 */
@Repository("TagDaoImpl")
@Transactional
public class TagDaoImpl extends HibernateBasicDaoSupport implements TagDao {

	@Override
	public void add(Tag tag) {
		getCurrentSession().save(tag);
	}

	@Override
	public void delete(Tag tag) {
		getCurrentSession().delete(tag);
	}

	@Override
	public List<Tag> getAllTags() {
		return getCurrentSession().createCriteria(Tag.class).list();
	}

	@Override
	public void modify(Tag tag) {
		getCurrentSession().update(tag);
	}

	@Override
	public List<Topic> getTopicsByTagName(String name) {
		return getCurrentSession().createCriteria(Topic.class)
				.add(Restrictions.eq("name", name)).list();
	}
}
