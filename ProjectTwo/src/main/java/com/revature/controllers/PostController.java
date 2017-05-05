package com.revature.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import com.revature.beans.*;
import com.revature.dao.*;
import com.revature.service.*;

@Controller
public class PostController {
	
	/*private PostService postService;
	
	@Autowired
	@Qualifier(value="service")
	public void setPostService (PostService ps) {
		this.postService = ps;
	}*/
	
	@RequestMapping(value = "index")
	public String getThreads(Model m) {
		PostDao dao = new PostDaoImpl();
		m.addAttribute("listThreads", dao.loadAll());
		return "index";
	}
	
	@RequestMapping(value = "thread/{threadId}",method=RequestMethod.GET)
	public String getThread(@PathVariable int threadId, Model m) {
		PostDao dao = new PostDaoImpl();
		m.addAttribute("threadId", threadId);
		m.addAttribute("listPosts", dao.loadThread(threadId));
		return "thread";
	}

	@RequestMapping(value = "thread/{threadId}/reply",method=RequestMethod.POST)
	public String addPost(@ModelAttribute("post") Post p) {
		PostDao dao = new PostDaoImpl();
		dao.create(p);;
		return "thread";
	}
	
	@RequestMapping(value = "thread/{threadId}/delete")
	public String removePost(@ModelAttribute("post") Post p) {
		PostDao dao = new PostDaoImpl();
		dao.delete(p);
		return "thread";
	}

}
