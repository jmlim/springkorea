package org.springkorea.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springkorea.model.User;
import org.springkorea.service.UserManager;

@Controller
@RequestMapping("/signin")
public class SigninController {

	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/processSignin", method = RequestMethod.POST)
	public @ResponseBody void processSignin(@RequestBody User user,
			HttpSession session) throws Exception {
		User loginUser = userManager.getUserByIdAndPassword(user.getUid(),
				user.getPassword());
		if (loginUser != null) {
			session.setAttribute("userSession", loginUser);
			return;
		}
		throw new Exception("인증실패");
	}

	@RequestMapping(value = "/processLogout", method = RequestMethod.GET)
	public @ResponseBody void processLogout(HttpSession session) {
		session.setAttribute("userSession", null);
	}

	@RequestMapping("/signin")
	public String getUserPartialPage() {
		return "user/signin";
	}
}
