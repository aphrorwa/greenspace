/**
 * 
 */
package org.rw.greenspace.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.rw.greenspace.util.GreenSpaceSessionFactory;

/**
 * @author student
 *
 */
public class DAO {
	
	protected DAO() {
	}

	/**
	 * 
	 * @return session
	 */
	public static Session getSession() {
		return GreenSpaceSessionFactory.getSession();
	}

	/**
	 * begins transaction
	 */
	protected void begin() {
		getSession().beginTransaction();
	}

	/**
	 * saves changes to the database
	 */
	protected void commit() {
		getSession().getTransaction().commit();
	}

	/**
	 * rolls back for failed transaction closes databases connection
	 * 
	 * @throws HibernateException
	 * 
	 */
	protected void rollback() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			System.out.println("Cannot rollback: " + e.toString());
		}
		try {
			getSession().close();
		} catch (HibernateException e) {
			System.out.println("Cannot close: " + e.toString());
		}
	}

}
