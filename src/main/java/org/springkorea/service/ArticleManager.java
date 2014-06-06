package org.springkorea.service;

import java.util.List;

import org.springkorea.model.Article;
import org.springkorea.persistence.valueobject.PagingOptions;

public interface ArticleManager {
	public Article getArticle(Article article);

	public void createArticle(Article article);

	public void updateArticle(Article article);

	public void deleteArticle(Integer id);

	public List<Article> getArticles(PagingOptions options);

	public Integer getCount();
}
