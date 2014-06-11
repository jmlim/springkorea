package org.springkorea.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springkorea.exception.UserNotFoundException;
import org.springkorea.model.Category;
import org.springkorea.model.User;
import org.springkorea.service.CategoryManager;
import org.springkorea.service.UserManager;

/**
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private UserManager userManager;

	@Autowired
	private CategoryManager categoryManager;

	@RequestMapping("/{ownerId}/categorylist.json")
	public @ResponseBody List<Category> getCategoryList(
			@PathVariable("ownerId") String ownerId) {
		// TODO
		Map<String, Object> options = new HashMap<>();
		options.put("offset", 0);
		options.put("size", 100);
		options.put("ownerId", ownerId);

		return categoryManager.getCategories(options);
	}

	@RequestMapping(value = "/{ownerId}/addCategory", method = RequestMethod.POST)
	public @ResponseBody void addCategory(@RequestBody Category category,
			@PathVariable("ownerId") String ownerId, HttpSession session)
			throws UserNotFoundException {
		User owner = userManager.getUser(ownerId);
		if (owner == null) {
			throw new UserNotFoundException();
		}
		category.setOwner(owner);
		category.setParent(new Category());
		category.setLeaf(false);
		categoryManager.createCategory(category);
	}

	@RequestMapping(value = "/{ownerId}/updateCategory", method = RequestMethod.PUT)
	public @ResponseBody void updateCategory(@RequestBody Category category,
			@PathVariable("ownerId") String ownerId) {
		categoryManager.updateCategory(category);
	}

	@RequestMapping(value = "/{ownerId}/removeCategory/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void removeCategory(@PathVariable("id") Integer id,
			@PathVariable("ownerId") String ownerId) {
		categoryManager.deleteCategory(id);
	}

	@RequestMapping("/list")
	public String getCategoryPartialPage() {
		return "category/list";
	}
}