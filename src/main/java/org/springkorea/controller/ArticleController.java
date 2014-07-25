package org.springkorea.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springkorea.exception.UserNotAuthorityException;
import org.springkorea.model.Article;
import org.springkorea.model.Category;
import org.springkorea.model.User;
import org.springkorea.service.ArticleManager;
import org.springkorea.service.CategoryManager;
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

	@Autowired
	private CategoryManager categoryManager;

	/**
	 * 게시판 리스트를 호출
	 * 
	 * @param ownerId
	 * @param categoryId
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/{ownerId}/{categoryId}/{pageNum}/articlelist.json")
	public @ResponseBody List<Article> getArticleList(
			@PathVariable("ownerId") String ownerId,
			@PathVariable("categoryId") String categoryId,
			@PathVariable("pageNum") Integer pageNum) {

		if (StringUtils.isBlank(ownerId)) {
			throw new NullPointerException("ownerId");
		}

		// TODO
		Integer cId = convertCategoryId(categoryId);

		Map<String, Object> options = new HashMap<>();

		Integer start = (pageNum * 10) + 1;
		Integer end = start + 9;
		options.put("start", start);
		options.put("end", end);
		options.put("ownerId", ownerId);

		Category category = null;
		if (cId != null) {
			category = categoryManager.getCategory(cId);
		}

		if (category == null) {
			category = categoryManager.getFirstCategory(options);
			cId = category.getId();
		}

		options.put("categoryId", cId);

		return articleManager.getArticles(options);
	}

	@RequestMapping("/{ownerId}/{categoryId}/pageCount")
	public @ResponseBody Integer getPageCount(
			@PathVariable("ownerId") String ownerId,
			@PathVariable("categoryId") String categoryId) {

		Map<String, Object> options = new HashMap<>();

		options.put("ownerId", ownerId);
		// TODO
		Integer cId = convertCategoryId(categoryId);
		Category category = null;
		if (cId != null) {
			category = categoryManager.getCategory(cId);
		}

		if (category == null) {
			category = categoryManager.getFirstCategory(options);
			cId = category.getId();
		}

		options.put("categoryId", cId);

		Integer articleListCount = articleManager.getCount(options);
		Integer pageCount = 0;
		if (articleListCount != null) {
			pageCount = articleListCount / 10;
			pageCount += articleListCount % 10 == 0 ? 0 : 1; 
		}
		return pageCount;
	}

	/**
	 * 게시판 글 쓰기
	 * 
	 * @param article
	 * @param ownerId
	 * @param categoryId
	 * @param session
	 * @throws UserNotAuthorityException
	 */
	@RequestMapping(value = "/{ownerId}/{categoryId}/addArticle", method = RequestMethod.POST)
	public @ResponseBody void addArticle(@RequestBody Article article,
			@PathVariable("ownerId") String ownerId,
			@PathVariable("categoryId") String categoryId, HttpSession session)
			throws UserNotAuthorityException {

		User owner = userManager.getUser(ownerId);
		User writer = (User) session.getAttribute("userSession");
		if (writer == null) {
			throw new UserNotAuthorityException("현재 세션이 존재하지 않므로 글을 쓸 수 없습니다.");
		}

		Integer cId = convertCategoryId(categoryId);
		Category category = null;
		if (cId != null) {
			category = categoryManager.getCategory(cId);
		}

		if (category == null) {
			Map<String, Object> options = new HashMap<>();
			options.put("ownerId", ownerId);
			category = categoryManager.getFirstCategory(options);
		}

		article.setOwner(owner);
		article.setWriter(writer);
		article.setCategory(category);
		article.setCreateDate(new Date());
		article.setUpdateDate(new Date());
		articleManager.createArticle(article);
	}

	@RequestMapping(value = "/{ownerId}/{categoryId}/updateArticle", method = RequestMethod.PUT)
	public @ResponseBody void updateArticle(@RequestBody Article article,
			@PathVariable("ownerId") String ownerId,
			@PathVariable("categoryId") String categoryId) {
		articleManager.updateArticle(article);
	}

	@RequestMapping(value = "/{ownerId}/{categoryId}/removeArticle/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void removeArticle(@PathVariable("id") Integer id,
			@PathVariable("ownerId") String ownerId,
			@PathVariable("categoryId") String categoryId) {
		articleManager.deleteArticle(id);
	}

	@RequestMapping("/article")
	public String getArticlePartialPage() {
		return "article/article";
	}

	/**
	 * @param categoryId
	 * @return
	 */
	private Integer convertCategoryId(String categoryId) {
		if (categoryId.equals("null") || categoryId.equals("undefined")) {
			categoryId = null;
		}

		Integer cId = null;
		if (categoryId != null) {
			cId = Integer.parseInt(categoryId);
		}
		return cId;
	}
}