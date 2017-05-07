package com.revature.main;

import org.springframework.context.support.*;

import com.revature.beans.Post;
import com.revature.dao.*;

public class Driver {

	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		Post newPost = (Post) ac.getBean("post");
		newPost.setComment("hello world");
		dao.create(newPost);
		System.out.println(newPost.toString());
		System.out.println(dao.loadAll());
		
		ac.close();

	}

}
