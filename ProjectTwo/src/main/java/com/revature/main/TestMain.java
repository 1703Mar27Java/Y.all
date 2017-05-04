package com.revature.main;

import java.sql.Timestamp;

import org.hibernate.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import com.revature.beans.*;
import com.revature.dao.util.HibernateUtil;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Post testPost = (Post) context.getBean("post");
		
		testPost.setParent(0);
		testPost.setTime(new Timestamp(System.currentTimeMillis()));
		testPost.setName("Mehrab");
		testPost.setSubject("TestTopic1");
		testPost.setComment("Test Comment Lorem Ipsum");

		tx.commit();
		session.close();
		((AbstractApplicationContext) context).close();
	}

}
