package com.revature.servlets;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import com.revature.beans.*;
import com.revature.dao.util.HibernateUtil;

public class NewThreadServlet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			Session hsesh = HibernateUtil.getSession();
			Transaction tx = hsesh.beginTransaction();
			
			Post testPost = (Post) context.getBean("post");

			testPost.setParent(0);
			testPost.setTime(new Timestamp(System.currentTimeMillis()));
			testPost.setName(req.getParameter("name"));
			testPost.setSubject(req.getParameter("subject"));
			testPost.setComment(req.getParameter("comment"));
			//testPost.setImage(new ByteArrayInputStream( "Hello".getBytes() ));
			hsesh.save(testPost);
			
			tx.commit();
			hsesh.close();
			((AbstractApplicationContext) context).close();
	        	        
        	resp.sendRedirect("index.html"); 
        } catch (Exception e) {
		}
	}
}
