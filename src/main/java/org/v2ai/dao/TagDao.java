package org.v2ai.dao;

import java.util.List;

import org.v2ai.entity.Tag;

/**
 * @ClassName:     Tag.java
 * @Description:   TODO
 * @author         iswin
 * @email          admin@iswin.org
 * @Date           2015年3月14日 下午11:56:32 
 */
public interface TagDao {

	void add(Tag tag);
	
	void delete(Tag tag);
	
	List<Tag> getAllTags();
	
	void modify(Tag tag);
}
