package org.v2ai.dao;

import org.v2ai.entity.Topic;

/**
 * @ClassName: TopicDao.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月17日 上午12:07:34
 */
public interface TopicDao {

	void add(Topic top);

	void delete(int topicid, int userid);

	void modify(Topic tp, int userid);

	// 这个方法放在这不知道合适不？，暂且先放着吧
	void userCollect(int topicid, int userid);

	boolean is_topicBelongsToCurrentUser(int topicid, int userid);
}
