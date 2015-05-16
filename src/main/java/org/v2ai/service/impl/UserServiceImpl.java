package org.v2ai.service.impl;

import java.net.URLEncoder;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.v2ai.dao.UserDao;
import org.v2ai.encrypt.RSACoder;
import org.v2ai.encrypt.RSAUtil;
import org.v2ai.entity.Result;
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
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Resource(name = "UserDaoImpl")
	private UserDao userDao;

	@Resource
	private SendMail mailsendHelper;

	@Resource
	private RSAUtil encryptTemplate;

	/***
	 * 用户注册
	 */
	@Override
	public Result register(User u) {
		if (userDao.user_Exist(u) == 1) {
			userDao.register(u);
			String verify = UUID.randomUUID().toString();
			userDao.addActiveLog(u.getEmail(), verify);
			verify = u.getEmail() + "||" + verify;
			try {
				mailsendHelper
						.sendMail(
								u.getEmail(),
								"http://www.iswin.org/active?code="
										+ URLEncoder.encode(
												encryptTemplate.encrypt(verify),
												"utf8"));
			} catch (Exception e) {
				return new Result(-1, e.getMessage());
			}
			return new Result(2, "注册成功");
		} else {
			return new Result(0, "用户已存在");
		}
	}

	/***
	 * 修改用户信息
	 */
	@Override
	public void modify(User u) {
		userDao.modity(u);
	}

	/***
	 * 删除用户
	 */
	@Override
	public void delete(User u) {
		userDao.delete(u);
	}

	/***
	 * 用户登录
	 */
	@Override
	public boolean login(User u) {
		return userDao.login(u);
	}

	/***
	 * 用户退出
	 */
	@Override
	public boolean logout(User u) {
		return false;
	}

	/***
	 * 用户激活
	 */
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

	/***
	 * 根据用户ID加载用户信息
	 */
	@Override
	public User getUser(User u) {
		return userDao.getUser(u);
	}

	/***
	 * 判断用户是否存在
	 */
	@Override
	public int user_Exist(User u) {
		return userDao.user_Exist(u);
	}

	/***
	 * 按用户名称获取用户信息
	 */
	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	/***
	 * 按用户邮件地址查询用户信息
	 */
	@Override
	public User getUserByemail(String email) {
		return userDao.getUserByemail(email);
	}

}
