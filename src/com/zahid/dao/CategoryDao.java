package com.zahid.dao;

import com.zahid.model.Category;

import java.util.List;

/**
 * Created by Zahid Iqbal Tushar.
 */
public interface CategoryDao {

    public void addCategory(Category category);
    public void deleteCategory(int id);
    public void updateCategory(Category category);
    public List<Category> getAllCategories();
    public Category getCategoryById(int id);

}
