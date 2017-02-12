package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveUser(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public User getUserWithKey(String randomkey) {
		List<User> user = new ArrayList<User>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		user = session.createQuery("from User where randomkey=?")
				.setParameter(0, randomkey).list();

		tx.commit();
		session.close();

		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}

	}

	public void updateUser(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
	}

	public List<User> getAllUserAccounts() {
		Session session = sessionFactory.openSession();

		// String s="FROM User ";
		Query query = session.createQuery("FROM User");

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		return list;
	}

	@SuppressWarnings("unchecked")
	public User getUserById(int id) {
		List<User> user = new ArrayList<User>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		user = session.createQuery("from User where id=?")
				.setParameter(0, id).list();

		tx.commit();
		session.close();

		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}

	public void deleteUser(int id) {
		
		//System.out.println(id);
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.load(User.class, new Integer(id));
		
			session.delete(user);
		
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public User verifyUserEmail(String email) {
		List<User> user = new ArrayList<User>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		user = session.createQuery("from User where email=?")
				.setParameter(0, email).list();

		tx.commit();
		session.close();

		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public User verifyingAccount(String randomkey) {
		List<User> user = new ArrayList<User>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		user = session.createQuery("from User where randomkey=? and active=1")
				.setParameter(0, randomkey).list();

		tx.commit();
		session.close();

		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}

}
