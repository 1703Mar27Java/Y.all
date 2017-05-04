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

@javax.servlet.annotation.MultipartConfig
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
			
			
			/**Jade: added image upload to servlet**/
			Part filePart = req.getPart("pic");
			InputStream input = filePart.getInputStream();
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[16384];
			while ((nRead = input.read(data, 0, data.length)) != -1) {
			  buffer.write(data, 0, nRead);
			}
			buffer.flush();
			byte[] imgData = buffer.toByteArray();
			testPost.setImage(imgData);
			
			
			hsesh.save(testPost);
			tx.commit();
			hsesh.close();
			((AbstractApplicationContext) context).close();
	        	        
        	resp.sendRedirect("index.html"); 
        } catch (Exception e) {
		}
	}
}
