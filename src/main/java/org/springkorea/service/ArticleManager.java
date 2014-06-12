package org.springkorea.service;

import java.util.List;
import java.util.Map;

import org.springkorea.model.Article;

public interface ArticleManager {
	public Article getArticle(Integer id);

	public void createArticle(Article article);

	public void updateArticle(Article article);

	public void deleteArticle(Integer id);

	public void deleteArticlesByCategoryId(Integer categoryId);

	public List<Article> getArticles(Map<String, Object> options);

	public Integer getCount(Map<String, Object> options);
}
