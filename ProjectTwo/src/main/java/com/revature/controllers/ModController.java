package com.revature.controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.Moderator;
import com.revature.beans.Post;
import com.revature.dao.ModDao;
import com.revature.dao.PostDao;

@Controller
@RequestMapping("/moderator")
public class ModController {
	
	@RequestMapping(value="/modLogin",method=RequestMethod.GET)
	public String modLogin(Model m) {
		return "modLogin";
	}
	
	@RequestMapping(value="/modLogin", method=RequestMethod.POST)
	public String modLogin(@RequestParam String username, @RequestParam String password,Model m){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ModDao dao = (ModDao) ac.getBean("myModDao");
		Moderator mod = dao.getModByLogin(username, password);
		m.addAttribute("mod", mod);
		return "catalog";
	}
}
