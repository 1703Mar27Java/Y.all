package com.revature.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;
import com.revature.dao.*;

@Controller
public class PostController {
	
	@RequestMapping(value = "index")
	public String getThreads(Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("listThreads", dao.loadAll());
		return "index";
	}
	
	@RequestMapping(value = "thread/{threadId}",method=RequestMethod.GET)
	public String getThread(@PathVariable int threadId, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("threadId", threadId);
		m.addAttribute("listPosts", dao.loadThread(threadId));
		return "thread";
	}

	@RequestMapping(value = "thread/{threadId}/reply",method=RequestMethod.POST)
	public String addPost(@ModelAttribute("post") Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		dao.create(p);;
		return "thread";
	}
	
	@RequestMapping(value = "thread/{threadId}/delete")
	public String removePost(@ModelAttribute("post") Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		dao.delete(p);
		return "thread";
	}

}
