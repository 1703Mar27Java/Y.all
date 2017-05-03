package com.revature.dao;

import java.sql.*;
import java.util.*;

import org.hibernate.Session;

import com.revature.beans.Post;
import com.revature.dao.util.HibernateUtil;

public class PostDaoImpl implements PostDao {

	@Override
	public int create(Post post) throws SQLException {
		return 0;
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> loadAll() throws SQLException {
		List<Post> posts = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		posts = session.createQuery("from Post").list();
		return posts;
	}

	@Override
	public int update(Post post) throws SQLException {
		Session s = HibernateUtil.getSession();
		int result = (int) s.save(post);
		s.close();
		return result;
	}

	@Override
	public int delete(Post post) throws SQLException {
		return 0;
		// TODO Auto-generated method stub

	}

}
