package org.v2ai.service.impl;

import java.net.URLEncoder;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.v2ai.dao.UserDao;
import org.v2ai.encrypt.RSAUtil;
import org.v2ai.entity.User;
import org.v2ai.exception.UserError;
import org.v2ai.service.SendMail;
import org.v2ai.service.UserService;

/**
 * @ClassName: UserServiceImpl.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月16日 上午12:33:18
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

	@Resource(name = "UserDaoImpl")
	private UserDao userDao;

	@Resource
	private SendMail mailsendHelper;

	@Resource
	private RSAUtil encryptTemplate;

	@Override
	public void register(User u) {
		if (userDao.user_Exist(u) == 1) {
			userDao.register(u);
			String verify = UUID.randomUUID().toString();
			userDao.addActiveLog(u.getEmail(), verify);
			verify = u.getEmail() + "||" + verify;
			try {
				mailsendHelper.sendMail(
						u.getEmail(),
						"http://www.iswin.org/active?code="
								+ URLEncoder.encode("", "utf8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void modify(User u) {
		userDao.modity(u);
	}

	@Override
	public void delete(User u) {
		userDao.delete(u);
	}

	@Override
	public boolean login(User u) {
		return userDao.login(u);
	}

	@Override
	public boolean logout(User u) {
		return false;
	}

	@Override
	public void userActive(String code) {
		String date = null;
		try {
			date = encryptTemplate.decrypt(code);
			String email = date.split("||")[0];
			String codes = date.split("||")[1];
			userDao.active(codes, email);
		} catch (Exception e) {
			throw new UserError(e.getMessage());
		}
	}

	@Override
	public User getUser(User u) {
		return userDao.getUser(u);
	}

	@Override
	public int user_Exist(User u) {
		return userDao.user_Exist(u);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public User getUserByemail(String email) {
		return userDao.getUserByemail(email);
	}

}
