/**
 * 
 */
package org.rw.greenspace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.rw.greenspace.dao.TreePlantedDAO;
import org.rw.greenspace.orm.Location;
import org.rw.greenspace.orm.TreePlanted;

/**
 * @author student
 * 
 */
public class TreePlantedDAOImpl extends DAO implements TreePlantedDAO {

	public static TreePlantedDAOImpl instance;

	public static TreePlantedDAOImpl getInstance() {
		if (instance == null) {
			return new TreePlantedDAOImpl();
		} else {
			return instance;
		}
	}

	@Override
	public TreePlanted saveTreePlanted(TreePlanted treePlanted) {
		try {
			begin();
			TreePlanted treePlant = (TreePlanted) getSession().save(treePlanted);
			commit();
			return treePlant;

		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public TreePlanted updateTreePlanted(TreePlanted treePlanted) {
		try {
			begin();
			getSession().update(treePlanted);
			commit();
			return treePlanted;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public TreePlanted saveOrUpdateTreePlanted(TreePlanted treePlanted) {
		try {
			begin();
			getSession().saveOrUpdate(treePlanted);
			commit();
			return treePlanted;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public boolean deleteTreePlanted(TreePlanted treePlanted) {
		try {
			begin();
			getSession().delete(treePlanted);
			commit();
			return true;
		} catch (Exception e) {
			rollback();
			return false;
		}
	}

	@Override
	public TreePlanted getTreePlantedById(int id) {
		try {
			begin();
			Query query = getSession().createQuery("from TreePlanted where id= :ref");
			query.setInteger("ref", id);
			TreePlanted treePlanted = (TreePlanted) query.uniqueResult();
			commit();
			return treePlanted;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public List<TreePlanted> getAllTreePlanteds() {
		try {
			begin();
			Query query = getSession().createQuery("from TreePlanted");
			List<TreePlanted> treePlants = query.list();
			commit();
			return treePlants;
		} catch (Exception e) {
			rollback();
			return new ArrayList<TreePlanted>();
		}
	}

	@Override
	public List<TreePlanted> getTreePlantedByTreePlantedName(
			String treePlantedName) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from TreePlanted where treePlantedName= :ref");
			query.setString("ref", treePlantedName);
			List<TreePlanted> treePlants = query.list();
			commit();
			return treePlants;
		} catch (Exception e) {
			rollback();
			return new ArrayList<TreePlanted>();
		}
	}

}
