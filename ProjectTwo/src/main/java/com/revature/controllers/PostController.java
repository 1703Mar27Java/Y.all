package com.revature.controllers;

import org.springframework.ui.Model;
<<<<<<< HEAD
=======
import org.springframework.validation.annotation.Validated;
>>>>>>> UserCreatePost
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;
import com.revature.dao.*;

@Controller
<<<<<<< HEAD
public class PostController {
	
	@RequestMapping(value = "index")
=======
@RequestMapping("/board")
public class PostController {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
>>>>>>> UserCreatePost
	public String getThreads(Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("listThreads", dao.loadAll());
		m.addAttribute("post", new Post());
		return "index";
	}
<<<<<<< HEAD
=======

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
>>>>>>> UserCreatePost
	
	@RequestMapping(value = "thread/{threadId}",method=RequestMethod.GET)
	public String getThread(@PathVariable int threadId, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
<<<<<<< HEAD
=======
		m.addAttribute("command", new Post());
>>>>>>> UserCreatePost
		m.addAttribute("threadId", threadId);
		m.addAttribute("listPosts", dao.loadThread(threadId));
		return "thread";
	}

<<<<<<< HEAD
	@RequestMapping(value = "thread/{threadId}/reply",method=RequestMethod.POST)
	public String addPost(@ModelAttribute("post") Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		dao.create(p);
=======
	@RequestMapping(value = "thread/{threadId}",method=RequestMethod.POST)
	public String addPost(@ModelAttribute("command") Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		//dao.create(p);
		System.out.println(p.toString());
>>>>>>> UserCreatePost
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
