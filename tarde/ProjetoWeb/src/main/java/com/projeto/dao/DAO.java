package com.projeto.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.projeto.util.HibernateUtil;

public class DAO {
	private static ThreadLocal threadlocal = new ThreadLocal();
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public DAO() {
		// TODO Auto-generated constructor stub
	}

	public static Session getSession() {
		Session session = (Session) threadlocal.get();
		if (session == null) {
			session = sessionFactory.openSession();
			threadlocal.set(session);
		}
		return session;
	}

	public void begin() {
		getSession().beginTransaction();

	}

	public void commit() {
		getSession().getTransaction().commit();
	}

	public void rollback() {
		getSession().getTransaction().rollback();
	}

	public void close() {
		getSession().close();
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

	// passamos ele para o Filter
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		DAO.sessionFactory = sessionFactory;
	}

}