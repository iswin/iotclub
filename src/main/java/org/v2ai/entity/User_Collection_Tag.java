package org.v2ai.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.jdbc.core.RowMapper;

/**
 * @ClassName: User_Collection_Tag.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月14日 下午4:31:00
 */
@Entity
public class User_Collection_Tag implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int user_id;
	private int tag_id;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp create_data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public Timestamp getCreate_data() {
		return create_data;
	}

	public void setCreate_data(Timestamp create_data) {
		this.create_data = create_data;
	}

}
