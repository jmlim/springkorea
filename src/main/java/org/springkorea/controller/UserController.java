package org.springkorea.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springkorea.model.User;
import org.springkorea.service.UserManager;
import org.springkorea.utils.MessageUtils;

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
	@ResponseBody
	public Map<String, Object> processSignupSubmit(
			@Valid @ModelAttribute User user, BindingResult result) {
		Map<String, Object> message = new HashMap<>();
		if (result.hasErrors()) {
			message.put("hasErrors", true);
			for (FieldError error : result.getFieldErrors()) {
				message.put(error.getField(), MessageUtils.getMessage(error));
			}
			return message;
		}

		User createdUser = userManager.createUser(user);
		message.put("success", createdUser);
		return message;
	}
}