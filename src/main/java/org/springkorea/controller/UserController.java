package org.springkorea.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springkorea.model.User;
import org.springkorea.service.UserManager;

/**
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserManager userManager;

	@ModelAttribute("user")
	public User createModel() {
		return new User();
	}

	@RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
	public String signinPage() {
		return "/user/signin";
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String signupPage() {
		return "/user/signup";
	}

	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute User user, HttpSession session) {

		User loginUser = userManager.getUserByIdAndPassword(user.getUid(),
				user.getPassword());

		if (loginUser != null) {
			session.setAttribute("userSession", loginUser);
			return "redirect:/index";
		}

		return "redirect:/user/signin";
	}

	@RequestMapping(value = "/processLogout", method = RequestMethod.GET)
	public String processLogout(HttpSession session) {
		session.setAttribute("userSession", null);
		return "redirect:/user/signin";
	}

	@RequestMapping(value = "/processSignupSubmit", method = RequestMethod.POST)
	public String processSignupSubmit(@ModelAttribute User user) {
		userManager.createUser(user);
		return "redirect:/user/signin";
	}
}