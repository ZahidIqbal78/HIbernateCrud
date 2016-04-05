package com.zahid.dao;

import com.zahid.model.Category;
import com.zahid.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zahid Iqbal Tushar.
 */
public class CategoryDaoImpl implements CategoryDao {
    @Override
    public void addCategory(Category category) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteCategory(int id) {
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();
            Category category = (Category) session.load(Category.class, new Integer(id));
            session.delete(category);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateCategory(Category category) {
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();
            categories = session.createQuery("FROM Category").list();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }

        return categories;
    }

    @Override
    public Category getCategoryById(int id){
        Category category = null;
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();
            String queryString = "from Category where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            category = (Category) query.uniqueResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return category;
    }
}
