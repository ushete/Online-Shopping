package com.us.onlineShopping.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView displayHome(){
		final ModelAndView mv = new ModelAndView("home");
		mv.addObject("greeting", "Hello... Welcome to Online Shopping!!");
		return mv;
	}
}
