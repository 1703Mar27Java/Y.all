package com.revature.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

import org.springframework.context.support.*;
import org.springframework.http.*;

import com.revature.beans.*;
import com.revature.dao.*;

@Controller
@RequestMapping("/board")
public class PostController {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String welcomePage(Model m) {
		return "index";
	}
	@RequestMapping(value="/modLogin",method=RequestMethod.GET)
	public String redirectToMod(Model m) {
		return "redirect:/moderator/modLogin";
	}

	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String getThreads(Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("listThreads", dao.loadThread(0));
		m.addAttribute("post", new Post());
		ac.close();
		return "catalog";
	}

	@RequestMapping(value = "/catalog", method = RequestMethod.POST)
	public String addThread(@ModelAttribute("post") @Validated Post p, @RequestParam("image") MultipartFile file, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		if (!file.isEmpty()) {			
            try {
				p.setImage(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}            
		}
		dao.create(p);
		m.addAttribute("threadId", p.getId());
		ac.close();
		return "result";
	}

	@RequestMapping(value = "/thread/{threadId}", method = RequestMethod.GET)
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

	@RequestMapping(value = "/thread/reply", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/board/img/${row.getId()}", method = RequestMethod.GET,
	        produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> ListImage(@PathVariable int threadId) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
	    Post p = dao.loadPost(threadId);
	    byte [] image = p.getImage();
	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
		ac.close();
	    return new ResponseEntity<byte[]>(image, headers, HttpStatus.CREATED);
	}

}