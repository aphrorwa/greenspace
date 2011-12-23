/**
 * 
 */
package org.rw.greenspace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.rw.greenspace.dao.UserDAO;
import org.rw.greenspace.orm.User;

/**
 * @author student
 * 
 */
public class UserDAOImpl extends DAO implements UserDAO {

	public static UserDAOImpl instance;

	public static UserDAOImpl getInstance() {
		if (instance == null) {
			return new UserDAOImpl();
		} else {
			return instance;
		}
	}

	@Override
	public User saveUser(User user) {
		try {
			begin();
			User usr = (User) getSession().save(user);
			commit();
			return usr;

		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public User updateUser(User user) {
		try {
			begin();
			getSession().update(user);
			commit();
			return user;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public User saveOrUpdateUser(User user) {
		try {
			begin();
			getSession().saveOrUpdate(user);
			commit();
			return user;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			begin();
			getSession().delete(user);
			commit();
			return true;
		} catch (Exception e) {
			rollback();
			return false;
		}
	}

	@Override
	public User getUserById(int id) {
		try {
			begin();
			Query query = getSession().createQuery("from User where id= :ref");
			query.setInteger("ref", id);
			User user = (User) query.uniqueResult();
			commit();
			return user;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {
		try {
			begin();
			Query query = getSession().createQuery("from User");
			List<User> users = query.list();
			commit();
			return users;
		} catch (Exception e) {
			rollback();
			return new ArrayList<User>();
		}
	}

	@Override
	public List<User> getUserByUsername(String username) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from User where username= :ref");
			query.setString("ref", username);
			List<User> users = query.list();
			commit();
			return users;
		} catch (Exception e) {
			rollback();
			return new ArrayList<User>();
		}
	}

	@Override
	public List<User> getUserByFullName(String fullName) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from User where fullName= :ref");
			query.setString("ref", fullName);
			List<User> users = query.list();
			commit();
			return users;
		} catch (Exception e) {
			rollback();
			return new ArrayList<User>();
		}
	}

}
