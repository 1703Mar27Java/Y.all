package com.revature.dao;

import java.util.*;
import org.hibernate.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Post;

@Transactional
public class PostDaoImpl implements PostDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void create(Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		ac.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> loadAll() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Session session = this.sessionFactory.getCurrentSession();
		List<Post> posts = session.createQuery("from Post").list();
		ac.close();
		return posts;
	}

	@Override
	public Post loadId(int id) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Session session = this.sessionFactory.getCurrentSession();
		Post p = (Post) session.load(Post.class, new Integer(id));
		ac.close();
		return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> loadThread(int id) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Post where id = " + id;
		List<Post> posts = session.createQuery(hql).list();
		ac.close();
		return posts;
	}

	@Override
	public void update(Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		ac.close();
	}

	@Override
	public void delete(Post p) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(p);
		ac.close();
	}

}
