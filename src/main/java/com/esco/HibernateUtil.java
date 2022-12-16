package com.esco;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public HibernateUtil() {

	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());

		return sessionFactory;
	}

	public static void closeConnection(SessionFactory sf) {
		sf.close();
	}

}
