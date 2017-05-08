package com.revature.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.support.*;

import com.revature.beans.*;
import com.revature.dao.*;

@Controller
@RequestMapping("/board")
public class PostController {
	
	@RequestMapping(value="/catalog",method=RequestMethod.GET)
	public String getThreads(Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("listThreads", dao.loadThread(0));
		m.addAttribute("post", new Post());
		ac.close();
		return "catalog";
	}

	@RequestMapping(value="/catalog",method=RequestMethod.POST)
	public String addThread(@ModelAttribute("post") @Validated Post p, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		dao.create(p);
		m.addAttribute("threadId", p.getId());
		ac.close();
		return "result";
	}
	
	@RequestMapping(value = "/thread/{threadId}",method=RequestMethod.GET)
	public String getThread(@PathVariable int threadId, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("op", dao.loadPost(threadId));
		m.addAttribute("post", new Post());
		m.addAttribute("threadId", threadId);
		m.addAttribute("listPosts", dao.loadThread(threadId));
		ac.close();
		return "thread";
	}

	@RequestMapping(value = "/thread/reply",method=RequestMethod.POST)
	public String addPost(@ModelAttribute("post") @Validated Post p, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		dao.create(p);
		m.addAttribute("threadId", p.getParent());
		ac.close();
		return "result";
	}
	
	@RequestMapping(value = "thread/{threadId}/delete")
	public String removePost(@ModelAttribute("post") @Validated Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		dao.delete(p);
		ac.close();
		return "result";
	}

}