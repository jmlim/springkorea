package org.springkorea.service;

import java.util.List;
import java.util.Map;

import org.springkorea.model.Category;

public interface CategoryManager {

	public Category getFirstCategory(Map<String, Object> options);

	public Category getCategory(Category category);

	public void createCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Integer id);

	public List<Category> getCategories(Map<String, Object> options);

	public Integer getCount();
}
