package com.revature.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;
import com.revature.dao.*;

@Controller
@RequestMapping("/board")
public class PostController {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getThreads(Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("listThreads", dao.loadAll());
		m.addAttribute("post", new Post());
		return "index";
	}

	@RequestMapping(value="/index",method=RequestMethod.POST)
	public String addThread(@ModelAttribute("post") @Validated Post p, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		dao.create(p);
		System.out.println(p.toString());
		m.addAttribute("name", p.getName());
		m.addAttribute("subject", p.getSubject());
		m.addAttribute("comment", p.getComment());
		return "result";
	}
	
	@RequestMapping(value = "thread/{threadId}",method=RequestMethod.GET)
	public String getThread(@PathVariable int threadId, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("command", new Post());
		m.addAttribute("threadId", threadId);
		m.addAttribute("listPosts", dao.loadThread(threadId));
		return "thread";
	}

	@RequestMapping(value = "thread/{threadId}",method=RequestMethod.POST)
	public String addPost(@ModelAttribute("command") Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		//dao.create(p);
		System.out.println(p.toString());
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
