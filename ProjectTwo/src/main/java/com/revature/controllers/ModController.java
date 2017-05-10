package com.revature.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.revature.beans.Moderator;
import com.revature.dao.ModDao;

@Controller
@RequestMapping("/moderator")
public class ModController {
	
	@RequestMapping(value="/modLogin",method=RequestMethod.GET)
	public String modLogin(Model m) {
		return "modlogin";
	}
	
	@RequestMapping(value="/modLogin", method=RequestMethod.POST)
	public ModelAndView modLogin(@RequestParam(value="username") String username,
								 @RequestParam(value="password") String password,
								 RedirectAttributes ra){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ModDao dao = (ModDao) ac.getBean("myModDao");
		Moderator mod = dao.getModByLogin(username, password);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/catalog");
		ra.addFlashAttribute("moderator", mod);
		ac.close();
		return mav;
	}
}
