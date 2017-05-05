package com.revature.controllers;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.revature.beans.*;

@Controller
@RequestMapping("/thread")
public class PostController {
	@RequestMapping(value="/{threadId}",method=RequestMethod.GET)
	public String getThread(@PathVariable int threadId, Model m) {
		m.addAttribute("threadId", threadId);
		return "thread";
	}
	
	@RequestMapping(value="/addPost",method=RequestMethod.GET)
	public String addPost(Model m){
		m.addAttribute("post",new Post());
		return "thread";
	}

}
