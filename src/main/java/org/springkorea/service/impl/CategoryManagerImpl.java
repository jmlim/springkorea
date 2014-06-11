package org.springkorea.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springkorea.model.Category;
import org.springkorea.persistence.mapper.CategoryMapper;
import org.springkorea.service.CategoryManager;

@Transactional
@Service("categoryManager")
public class CategoryManagerImpl implements CategoryManager {

	@Autowired
	private CategoryMapper categoryMapper;

	/**
	 * @see org.springkorea.service.CategoryManager#getFirstCategory(java.util.Map)
	 */
	@Override
	public Category getFirstCategory(Map<String, Object> options) {
		return categoryMapper.getFirstCategory(options);
	}

	/**
	 * @see org.springkorea.service.CategoryManager#getCategory(org.springkorea.model.Category)
	 */
	@Override
	public Category getCategory(Category category) {
		return categoryMapper.getCategory(category);
	}

	/**
	 * @see org.springkorea.service.CategoryManager#createCategory(org.springkorea.model.Category)
	 */
	@Override
	public void createCategory(Category category) {
		categoryMapper.createCategory(category);
	}

	/**
	 * @see org.springkorea.service.CategoryManager#updateCategory(org.springkorea.model.Category)
	 */
	@Override
	public void updateCategory(Category category) {
		categoryMapper.updateCategory(category);
	}

	/**
	 * @see org.springkorea.service.CategoryManager#deleteCategory(java.lang.Integer)
	 */
	@Override
	public void deleteCategory(Integer id) {
		categoryMapper.deleteCategory(id);
	}

	/**
	 * @see org.springkorea.service.CategoryManager#getCategories(java.util.Map)
	 */
	@Override
	public List<Category> getCategories(Map<String, Object> options) {
		return categoryMapper.getCategories(options);
	}

	/**
	 * @see org.springkorea.service.CategoryManager#getCount()
	 */
	@Override
	public Integer getCount() {
		return categoryMapper.getCount();
	}
}
