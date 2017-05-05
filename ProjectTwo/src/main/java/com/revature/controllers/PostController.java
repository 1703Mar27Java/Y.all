package com.revature.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.revature.beans.*;
import com.revature.dao.*;

@Controller
@RequestMapping("/thread")
public class PostController {
	@RequestMapping(value = "/{threadId}", method = RequestMethod.GET)
	public String getThread(@PathVariable int threadId, Model m) {
		PostDao dao = new PostDaoImpl();
		try {
			List<Post> posts = dao.loadAll();
			List<Post> filtered = new ArrayList<>();
			for (Post i : posts) {
				if (i.getParent() == threadId)
					filtered.add(i);
			}
			m.addAttribute("filtered", filtered);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "thread";
	}

	@RequestMapping(value = "/addPost", method = RequestMethod.GET)
	public String addPost(Model m) {
		m.addAttribute("post", new Post());
		return "thread";
	}

}
