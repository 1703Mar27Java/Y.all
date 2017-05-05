package com.revature.dao;

import java.sql.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Post;
import com.revature.dao.util.HibernateUtil;

public class PostDaoImpl implements PostDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> loadAll() throws SQLException {
		List<Post> posts = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		posts = session.createQuery("from Post").list();
		return posts;
	}

	@Override
	public void update(Post post) throws SQLException {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(post);
		tx.commit();
		s.close();
	}

	@Override
	public int delete(Post post) throws SQLException {
		return 0;
	}

}
