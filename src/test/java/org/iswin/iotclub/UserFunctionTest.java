package org.iswin.iotclub;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.v2ai.dao.TagDao;
import org.v2ai.dao.UserDao;
import org.v2ai.encrypt.RSAUtil;
import org.v2ai.entity.User;
import org.v2ai.service.SendMail;
import org.v2ai.service.UserService;

/**
 * @ClassName: UserFunctionTest.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月15日 下午5:48:43
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:servlet-context.xml",
		"classpath:root-context.xml" })
public class UserFunctionTest {

	@Resource(name = "TagDaoImpl")
	private TagDao tagDao;

	@Resource(name = "UserDaoImpl")
	private UserDao userdao;

	@Resource(name = "UserService")
	private UserService userService;

	@Resource
	private SendMail mailsendHelper;

	@Resource
	private RSAUtil encryptTemplate;

	@Test
	public void addUser() {
		User u = new User("jimwbys", "password", "jimwbys@gmail.com",
				"http://www.iswin.org", "that is a test", "weibo", "tv", null);
		userService.register(u);
	}

	@Test
	public void modify() {
		User u = userdao.getUserByemail("admin@iswin.org");
		u.setPassword("123456789");
		userdao.modity(u);
	}

	@Test
	public void find() {
		System.out.println(userdao.getUserByemail("admin@iswin.org")
				.getPassword());
	}

	@Test
	public void delete() {
		userdao.delete(userdao.getUserByemail("admin@iswin.org"));
	}

	@Test
	public void mailSend() {
		mailsendHelper.sendMail("admin@iswin.org", "物联网社区");
	}

	@Test
	public void encrypt() throws Exception {
		System.out.println(encryptTemplate.encrypt("admin"));
	}
}
