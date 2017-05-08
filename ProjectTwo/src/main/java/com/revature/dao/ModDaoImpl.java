package com.revature.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Moderator;

@Transactional
public class ModDaoImpl implements ModDao{
	private SessionFactory sessionFactory;
	
	@Override
	public void persistMod(Moderator m) {
		Session s = sessionFactory.getCurrentSession();
		s.persist(m);
	}

	@Override
	public void deleteMod(Moderator m) {
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("delete from Moderator where id = :mID ");
		q.setParameter("mID", m.getId());
		q.executeUpdate();
	}

	@Override
	public Moderator getModById(int id) {
		Session s = sessionFactory.getCurrentSession();
		Moderator m = (Moderator) s.createQuery("from Moderator where id = :mID").setParameter("mID",id);
		return m;
	}

	@Override
	public Moderator getModByLogin(String username, String password) {
		Session s = sessionFactory.getCurrentSession();
		Moderator m = (Moderator) s.createQuery("from Moderator where username = ? and password = ?")
								   .setString(0, username).setString(1, password);
		return m;
	}

}
