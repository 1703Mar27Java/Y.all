package com.revature.main;

import java.sql.*;

import org.hibernate.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import com.revature.beans.*;
import com.revature.dao.*;
import com.revature.dao.util.HibernateUtil;

public class TestMain {

	public static void main(String[] args) {
		testPost();		
	}
	
	static void testPost() {
		PostDao dao = new PostDaoImpl();
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Post testPost = (Post) context.getBean("post");
		
		testPost.setParent(4);
		testPost.setTime(new Timestamp(System.currentTimeMillis()));
		testPost.setComment("Reply to parent post");
		//testPost.setImage(new ByteArrayInputStream( "Hello".getBytes() ));
		
		try {
			dao.update(testPost);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		((AbstractApplicationContext) context).close();
	}

	static void testThread() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Post testPost = (Post) context.getBean("post");
		((AbstractApplicationContext) context).close();
		
		testPost.setParent(0);
		testPost.setTime(new Timestamp(System.currentTimeMillis()));
		testPost.setName("Mehrab");
		testPost.setSubject("TestTopic");
		testPost.setComment("Test Comment Lorem Ipsum");
		//testPost.setImage(new ByteArrayInputStream( "Hello".getBytes() ));
		session.save(testPost);
		
		tx.commit();
		session.close();
	}
}
