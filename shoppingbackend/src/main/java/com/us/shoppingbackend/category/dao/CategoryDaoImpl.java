package com.us.shoppingbackend.category.dao;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.us.shoppingbackend.category.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Category> getAllCategories(){
		List<Category> categories = new ArrayList<>();

		Category c1 = new Category();
		c1.setCategoryId(1);
		c1.setName("Televisions");
		categories.add(c1);

		Category c2 = new Category();
		c2.setCategoryId(1);
		c2.setName("Laptops");
		categories.add(c2);

		Category c3 = new Category();
		c3.setCategoryId(1);
		c3.setName("Mobiles");
		categories.add(c3);

		try{
			categories = sessionFactory.getCurrentSession().createQuery("from Category").getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return categories;
	}

}
