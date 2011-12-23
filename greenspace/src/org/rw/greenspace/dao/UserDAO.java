/**
 * 
 */
package org.rw.greenspace.dao;

import java.util.List;

import org.rw.greenspace.orm.User;

/**
 * @author student
 * user access object
 *
 */
public interface UserDAO {
	
	public User saveUser(User user);

	public User updateUser(User user);

	public User saveOrUpdateUser(User user);

	public boolean deleteUser(User user);

	public User getUserById(int id);

	public List<User> getAllUsers();

	public List<User> getUserByUsername(String username);

	public List<User> getUserByFullName(String fullName);

}
