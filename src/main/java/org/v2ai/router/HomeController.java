package org.v2ai.router;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.v2ai.dao.TagDao;
import org.v2ai.dao.UserDao;
import org.v2ai.entity.Tag;

@Controller
public class HomeController {

	@Resource(name = "TagDaoImpl")
	private TagDao tagDao;

	@Resource(name = "UserDaoImpl")
	private UserDao userdao;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		tagDao.add(new Tag("iswin", "test", 1));
		System.out.println(tagDao.getAllTags().get(0).getDescription());
		try {
			//userdao.active("iswinsssss");
		} catch (UnknownError e) {
			model.addAttribute("serverTime", e.getMessage());
		}
		return "home";
	}

}
