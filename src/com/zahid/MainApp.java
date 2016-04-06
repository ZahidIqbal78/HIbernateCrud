package com.zahid;

import com.zahid.dao.CategoryDaoImpl;
import com.zahid.model.Category;

/**
 * Created by Zahid Iqbal Tushar.
 */
public class MainApp {

    public static void main(String[] args){

        CategoryDaoImpl categoryDao = new CategoryDaoImpl();

        Category category1 = new Category();
        category1.setCategory("Category 1");

        Category category2 = new Category();
        category2.setCategory("Category 2");

        //add category to db
        categoryDao.addCategory(category1);
        categoryDao.addCategory(category2);


        Category category3 = new Category();
        category3.setCategory("Category 3");
        categoryDao.addCategory(category3);
        category3.setId(3);
        category3.setCategory("Category 4");
        categoryDao.updateCategory(category3);

    }
}
