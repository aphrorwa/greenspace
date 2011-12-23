/**
 * 
 */
package org.rw.greenspace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.rw.greenspace.dao.TreeHarvestedDAO;
import org.rw.greenspace.orm.TreeHarvested;

/**
 * @author student
 * 
 */
public class TreeHarvestedDAOImpl extends DAO implements TreeHarvestedDAO {

	public static TreeHarvestedDAOImpl instance;

	public static TreeHarvestedDAOImpl getInstance() {
		if (instance == null) {
			return new TreeHarvestedDAOImpl();
		} else {
			return instance;
		}
	}

	public TreeHarvestedDAOImpl() {
	}

	@Override
	public TreeHarvested saveTreeHarvested(TreeHarvested treeHarvested) {
		try {
			begin();
			TreeHarvested treeHarv = (TreeHarvested) getSession().save(treeHarvested);
			commit();
			return treeHarv;

		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public TreeHarvested updateTreeHarvested(TreeHarvested treeHarvested) {
		try {
			begin();
			getSession().update(treeHarvested);
			commit();
			return treeHarvested;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public TreeHarvested saveOrUpdateTreeHarvested(TreeHarvested treeHarvested) {
		try {
			begin();
			getSession().saveOrUpdate(treeHarvested);
			commit();
			return treeHarvested;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public boolean deleteTreeHarvested(TreeHarvested treeHarvested) {
		try {
			begin();
			getSession().delete(treeHarvested);
			commit();
			return true;
		} catch (Exception e) {
			rollback();
			return false;
		}
	}

	@Override
	public TreeHarvested getTreeHarvestedById(int id) {
		try {
			begin();
			Query query = getSession().createQuery("from TreePlanted where id= :ref");
			query.setInteger("ref", id);
			TreeHarvested treeHarvested = (TreeHarvested) query.uniqueResult();
			commit();
			return treeHarvested;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TreeHarvested> getAllTreeHarvesteds() {
		try {
			begin();
			Query query = getSession().createQuery("from TreeHarvested");
			List<TreeHarvested> treeHarvs = query.list();
			commit();
			return treeHarvs;
		} catch (Exception e) {
			rollback();
			return new ArrayList<TreeHarvested>();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TreeHarvested> getTreeHarvestedByTreeHarvestedName(
			String treeHarvestedName) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from TreeHarvested where treeHarvestedName= :ref");
			query.setString("ref", treeHarvestedName);
			List<TreeHarvested> treeHarvs = query.list();
			commit();
			return treeHarvs;
		} catch (Exception e) {
			rollback();
			return new ArrayList<TreeHarvested>();
		}
	}

}
