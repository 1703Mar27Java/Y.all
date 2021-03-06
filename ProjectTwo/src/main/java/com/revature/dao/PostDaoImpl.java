package com.revature.dao;

import java.sql.Timestamp;
import java.util.*;

import org.hibernate.*;
import org.springframework.transaction.annotation.*;

import com.revature.beans.Post;

@Transactional
public class PostDaoImpl implements PostDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void create(Post p) {
		Session session = this.sessionFactory.getCurrentSession();
		p.setTime(new Timestamp(System.currentTimeMillis()));
		session.save(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> loadFlags() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Post P WHERE P.flag = 1 ORDER BY P.id";
		return session.createQuery(hql).list();
	}

	@Override
	public Post loadPost(int id) throws NullPointerException{
		Session session = this.sessionFactory.getCurrentSession();
		Post p = (Post) session.get(Post.class, new Integer(id));
		if(p == null){
			throw new NullPointerException("Specified post doesn't exist");
		}
		return p;
	}
	
	//@SuppressWarnings("unchecked")
	@Override
	public List<Post> loadThread(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Post P WHERE P.parent = " + id + " ORDER BY P.id";
		return session.createQuery(hql).list();
	}

	@Override
	public void update(Post p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@Override
	public void delete(Post p) {
		Session session = this.sessionFactory.getCurrentSession();
		if (p.getParent() == 0) {
			Query query = session.createQuery("DELETE Post p WHERE p.parent = :parentId");
			query.setParameter("parentId", p.getId());
			query.executeUpdate();
		}
		session.delete(p);
	}

}
