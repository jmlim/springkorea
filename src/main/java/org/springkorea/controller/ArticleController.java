package org.springkorea.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springkorea.model.Article;
import org.springkorea.model.User;
import org.springkorea.persistence.valueobject.PagingOptions;
import org.springkorea.service.ArticleManager;
import org.springkorea.service.UserManager;

/**
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private UserManager userManager;

	@Autowired
	private ArticleManager articleManager;

	@RequestMapping("/{ownerId}/articlelist.json")
	public @ResponseBody List<Article> getArticleList(
			@PathVariable("ownerId") String ownerId) {
		// TODO
		PagingOptions options = new PagingOptions();
		options.setOffset(0);
		options.setSize(100);

		return articleManager.getArticles(options);
	}

	@RequestMapping(value = "/{ownerId}/addArticle", method = RequestMethod.POST)
	public @ResponseBody void addArticle(@RequestBody Article article,
			@PathVariable("ownerId") String ownerId, HttpSession session)
			throws Exception {

		User owner = userManager.getUser(ownerId);
		User writer = (User) session.getAttribute("userSession");
		if (writer == null) {
			throw new Exception();
		}

		article.setOwner(owner);
		article.setWriter(writer);
		article.setCreateDate(new Date());
		article.setUpdateDate(new Date());
		articleManager.createArticle(article);
	}

	@RequestMapping(value = "/{ownerId}/updateArticle", method = RequestMethod.PUT)
	public @ResponseBody void updateArticle(@RequestBody Article article,
			@PathVariable("ownerId") String ownerId) {
		articleManager.updateArticle(article);
	}

	@RequestMapping(value = "/{ownerId}/removeArticle/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void removeArticle(@PathVariable("id") Integer id,
			@PathVariable("ownerId") String ownerId) {
		articleManager.deleteArticle(id);
	}

	@RequestMapping("/list")
	public String getArticlePartialPage() {
		return "article/list";
	}
}