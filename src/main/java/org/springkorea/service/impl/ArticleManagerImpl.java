package org.springkorea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springkorea.model.Article;
import org.springkorea.persistence.mapper.ArticleMapper;
import org.springkorea.persistence.valueobject.PagingOptions;
import org.springkorea.service.ArticleManager;

@Transactional
@Service("articleManager")
public class ArticleManagerImpl implements ArticleManager {

	@Autowired
	private ArticleMapper articleMapper;

	/**
	 * @see org.springkorea.service.ArticleManager#getArticle(org.springkorea.model.Article)
	 */
	@Override
	public Article getArticle(Article article) {
		return articleMapper.getArticle(article);
	}

	/**
	 * @see org.springkorea.service.ArticleManager#createArticle(org.springkorea.model.Article)
	 */
	@Override
	public void createArticle(Article article) {
		articleMapper.createArticle(article);
	}

	/**
	 * @see org.springkorea.service.ArticleManager#updateArticle(org.springkorea.model.Article)
	 */
	@Override
	public void updateArticle(Article article) {
		articleMapper.updateArticle(article);
	}

	/**
	 * @see org.springkorea.service.ArticleManager#deleteArticle(java.lang.Integer)
	 */
	@Override
	public void deleteArticle(Integer id) {
		articleMapper.deleteArticle(id);
	}

	/**
	 * @see org.springkorea.service.ArticleManager#getArticles(org.springkorea.persistence.valueobject.PagingOptions)
	 */
	@Override
	public List<Article> getArticles(PagingOptions options) {
		return articleMapper.getArticles(options);
	}

	/**
	 * @see org.springkorea.service.ArticleManager#getCount()
	 */
	@Override
	public Integer getCount() {
		return articleMapper.getCount();
	}

}
