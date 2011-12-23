/**
 * 
 */
package org.rw.greenspace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.rw.greenspace.dao.SeedDAO;
import org.rw.greenspace.orm.Seed;
import org.rw.greenspace.orm.Tree;

/**
 * @author student
 * 
 */
public class SeedDAOImpl extends DAO implements SeedDAO {

	public static SeedDAOImpl instance;

	public static SeedDAOImpl getInstance() {
		if (instance == null) {
			return new SeedDAOImpl();
		} else {
			return instance;
		}
	}

	public SeedDAOImpl() {
	}

	@Override
	public Seed saveSeed(Seed seed) {
		try {
			begin();
			Seed sd = (Seed) getSession().save(seed);
			commit();
			return sd;

		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public Seed updateSeed(Seed seed) {
		try {
			begin();
			getSession().update(seed);
			commit();
			return seed;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public Seed saveOrUpdateSeed(Seed seed) {
		try {
			begin();
			getSession().saveOrUpdate(seed);
			commit();
			return seed;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public boolean deleteSeed(Seed seed) {
		try {
			begin();
			getSession().delete(seed);
			commit();
			return true;
		} catch (Exception e) {
			rollback();
			return false;
		}
	}

	@Override
	public Seed getSeedById(int id) {
		try {
			begin();
			Query query = getSession().createQuery("from Seed where id= :ref");
			query.setInteger("ref", id);
			Seed seed = (Seed) query.uniqueResult();
			commit();
			return seed;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public List<Seed> getAllSeeds() {
		try {
			begin();
			Query query = getSession().createQuery("from Seed");
			List<Seed> seeds = query.list();
			commit();
			return seeds;
		} catch (Exception e) {
			rollback();
			return new ArrayList<Seed>();
		}
	}
// a reviser data type
	@Override
	public List<Seed> getSeedByTree(Tree tree) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from Seed where treeName= :ref");
			query.setString("ref", tree.getTreeName());
			List<Seed> trees = query.list();
			commit();
			return trees;
		} catch (Exception e) {
			rollback();
			return new ArrayList<Seed>();
		}
	}

}
