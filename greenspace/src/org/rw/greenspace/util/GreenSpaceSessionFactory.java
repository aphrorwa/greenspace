/**
 * 
 */
package org.rw.greenspace.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * @author student
 *
 */
public class GreenSpaceSessionFactory {
	
	private static SessionFactory sessionFactory;
	private static Configuration configuration = new AnnotationConfiguration();
	private static String configFile = "org/rw/greenspace/util/hibernate.cfg.xml";

	private GreenSpaceSessionFactory() {
	}

	/**
	 * gets instance
	 * 
	 * @return sessionFactory
	 */
	public static SessionFactory getInstance() {
		if (sessionFactory == null) {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	}

	/**
	 * gets session
	 * 
	 * @return session
	 */
	public static Session getSession() {
		Session session = getInstance().getCurrentSession();
		if (session == null) {
			session = getInstance().openSession();
		}
		if (!session.isOpen()) {
			session = getInstance().openSession();
		}
		return session;
	}
}
