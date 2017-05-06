package com.revature.service;

import java.util.List;

import org.springframework.stereotype.*;
import org.springframework.context.support.*;
import org.springframework.transaction.annotation.*;

import com.revature.beans.*;
import com.revature.dao.*;

@Service
public class PostService {
	
	private PostDao dao;
	
	public void setPostDao(PostDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public void createPost(Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		this.dao.create(p);
		ac.close();
	}
	
	@Transactional
	public void updatePost(Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		this.dao.update(p);
		ac.close();
	}
	
	@Transactional
	public List<Post> listPosts() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		List<Post> posts = this.dao.loadAll();
		ac.close();
		return posts;
	}
	
	@Transactional
	public Post getPost(int id) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Post post= this.dao.loadId(id);
		ac.close();
		return post;
	}
	
	@Transactional
	public void deletePost(Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		this.dao.delete(p);
		ac.close();
	}

}
