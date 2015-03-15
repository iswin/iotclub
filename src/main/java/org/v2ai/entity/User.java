package org.v2ai.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @ClassName: User.java
 * @Description: 用户表
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月14日 上午1:37:49
 */

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	private String blog_url;
	private String signature;
	private String weibo;
	private String avatar;
	private boolean is_block;
	private int score;
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp register_date;
	private Timestamp update_date;
	@Column(columnDefinition = "bool default false")
	private boolean is_star;
	private String level;
	@Column(columnDefinition = "bool default false")
	private boolean is_active;
	@Column(columnDefinition = "bool default true")
	private boolean notification_reply_mail;
	@Column(columnDefinition = "bool default true")
	private boolean notification_at_mail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBlog_url() {
		return blog_url;
	}

	public void setBlog_url(String blog_url) {
		this.blog_url = blog_url;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isIs_block() {
		return is_block;
	}

	public void setIs_block(boolean is_block) {
		this.is_block = is_block;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timestamp getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Timestamp register_date) {
		this.register_date = register_date;
	}

	public Timestamp getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}

	public boolean isIs_start() {
		return is_star;
	}

	public void setIs_start(boolean is_start) {
		this.is_star = is_start;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean isNotification_reply_mail() {
		return notification_reply_mail;
	}

	public void setNotification_reply_mail(boolean notification_reply_mail) {
		this.notification_reply_mail = notification_reply_mail;
	}

	public boolean isNotification_at_mail() {
		return notification_at_mail;
	}

	public void setNotification_at_mail(boolean notification_at_mail) {
		this.notification_at_mail = notification_at_mail;
	}

}
