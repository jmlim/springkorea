package org.springkorea.controller;

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

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String signupPage() {
		return "/user/signup";
	}

	@RequestMapping(value = "/processSubmit", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute User newUser) {
		userManager.createUser(newUser);
		return "redirect:/user/signin";
	}
}