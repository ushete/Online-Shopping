package com.us.onlineshopping.home;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.us.shoppingbackend.category.dao.CategoryDao;
import com.us.shoppingbackend.category.dto.Category;

@Controller
public class HomeController {

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView displayHome(){
		final ModelAndView mv = new ModelAndView("home");
		mv.addObject("greeting", "Hello... Welcome to Online Shopping!!");
		final List<Category> categories = categoryDao.getAllCategories();
		mv.addObject("categories", categories);
		return mv;
	}
}
