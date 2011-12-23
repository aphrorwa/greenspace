/**
 * 
 */
package org.rw.greenspace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.rw.greenspace.dao.TreeDAO;
import org.rw.greenspace.orm.Tree;
import org.rw.greenspace.orm.User;

/**
 * @author student
 * 
 */
public class TreeDAOImpl extends DAO implements TreeDAO {

	public static TreeDAOImpl instance;

	public static TreeDAOImpl getInstance() {
		if (instance == null) {
			return new TreeDAOImpl();
		} else {
			return instance;
		}
	}

	public TreeDAOImpl() {
	}

	@Override
	public Tree saveTree(Tree tree) {
		try {
			begin();
			Tree tr = (Tree) getSession().save(tree);
			commit();
			return tr;

		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public Tree updateTree(Tree tree) {
		try {
			begin();
			getSession().update(tree);
			commit();
			return tree;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public Tree saveOrUpdateTree(Tree tree) {
		try {
			begin();
			getSession().saveOrUpdate(tree);
			commit();
			return tree;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public boolean deleteTree(Tree tree) {
		try {
			begin();
			getSession().delete(tree);
			commit();
			return true;
		} catch (Exception e) {
			rollback();
			return false;
		}
	}

	@Override
	public Tree getTreeById(int id) {
		try {
			begin();
			Query query = getSession().createQuery("from Tree where id= :ref");
			query.setInteger("ref", id);
			Tree tree = (Tree) query.uniqueResult();
			commit();
			return tree;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public List<Tree> getAllTrees() {
		try {
			begin();
			Query query = getSession().createQuery("from Tree");
			List<Tree> trees = query.list();
			commit();
			return trees;
		} catch (Exception e) {
			rollback();
			return new ArrayList<Tree>();
		}
	}

	@Override
	public Tree getTreeByTreeName(String treeName) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from Tree where treeName= :ref");
			query.setString("ref", treeName);
			Tree tree = (Tree) query.uniqueResult();
			commit();
			return tree;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

}
