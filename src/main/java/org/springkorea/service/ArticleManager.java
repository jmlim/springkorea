package org.springkorea.service;

import java.util.List;
import java.util.Map;

import org.springkorea.model.Article;

public interface ArticleManager {
	public Article getArticle(Article article);

	public void createArticle(Article article);

	public void updateArticle(Article article);

	public void deleteArticle(Integer id);

	public List<Article> getArticles(Map<String, Object> options);

	public Integer getCount();
}
