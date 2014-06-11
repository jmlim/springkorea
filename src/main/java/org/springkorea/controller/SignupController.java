package org.springkorea.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springkorea.model.User;
import org.springkorea.service.UserManager;

/**
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	private UserManager userManager;

	@RequestMapping("/userlist.json")
	public @ResponseBody List<User> getUserList() {
		return userManager.getUsers();
	}

	@RequestMapping(value = "/currentUser")
	public @ResponseBody User currentUser(HttpSession session) {
		User currentUser = (User) session.getAttribute("userSession");
		if (currentUser != null) {
			return currentUser;
		}

		return null;
	}

	@RequestMapping(value = "/getAccessBlogUser")
	public @ResponseBody User getAccessBlogUser(HttpSession session) {
		User accessBlogUser = (User) session.getAttribute("accessBlogUser");
		if (accessBlogUser != null) {
			return accessBlogUser;
		}

		return null;
	}

	@RequestMapping(value = "/setAccessBlogUser", method = RequestMethod.POST)
	public @ResponseBody User setAccessBlogUser(@RequestBody User user,
			HttpSession session) {
		if (user != null) {
			session.setAttribute("accessBlogUser", user);
			return user;
		}
		return null;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody void addUser(@RequestBody User user) {
		userManager.createUser(user);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public @ResponseBody void updateUser(@RequestBody User user,
			HttpSession session) {
		userManager.updateUser(user);
		User currentUser = (User) session.getAttribute("userSession");
		if (currentUser.getUid().equals(user.getUid())) {
			session.setAttribute("userSession", user);
		}
	}

	@RequestMapping(value = "/removeUser/{uid}", method = RequestMethod.DELETE)
	public @ResponseBody void removeUser(@PathVariable("uid") String uid) {
		userManager.deleteUser(uid);
	}

	@RequestMapping("/signup")
	public String getUserPartialPage() {
		return "user/signup";
	}

	@RequestMapping("/users")
	public String getUsersPage() {
		return "user/users";
	}
}