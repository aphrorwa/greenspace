/**
 * 
 */
package org.rw.greenspace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.rw.greenspace.dao.LocationDAO;
import org.rw.greenspace.orm.Location;
import org.rw.greenspace.orm.User;

/**
 * @author student
 * 
 */
public class LocationDAOImpl extends DAO implements LocationDAO {

	public static LocationDAOImpl instance;

	public static LocationDAOImpl getInstance() {
		if (instance == null) {
			return new LocationDAOImpl();
		} else {
			return instance;
		}
	}

	public LocationDAOImpl() {
	}

	@Override
	public Location saveLocation(Location location) {
		try {
			begin();
			Location loc = (Location) getSession().save(location);
			commit();
			return loc;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public Location updateLocation(Location location) {
		try {
			begin();
			getSession().update(location);
			commit();
			return location;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public Location saveOrUpdateLocation(Location location) {
		try {
			begin();
			getSession().saveOrUpdate(location);
			commit();
			return location;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public boolean deleteLocation(Location location) {
		try {
			begin();
			Query query = getSession().createQuery("from Location where id= :ref");
			query.setInteger("ref", location.getId());
			Location loc=(Location) query.uniqueResult();
			getSession().delete(loc);
			commit();
			return true;
		} catch (Exception e) {
			rollback();
			return false;
		}
	}

	@Override
	public Location getLocationById(int id) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from Location where id= :ref");
			query.setInteger("ref", id);
			Location location = (Location) query.uniqueResult();
			commit();
			return location;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

	@Override
	public List<Location> getAllLocations() {
		try {
			begin();
			Query query = getSession().createQuery("from Location");
			List<Location> locations = query.list();
			commit();
			return locations;
		} catch (Exception e) {
			rollback();
			return new ArrayList<Location>();
		}
	}

	@Override
	public Location getLocationByLocationCode(String locationCode) {
		try {
			begin();
			Query query = getSession().createQuery(
					"from Location where locationCode= :ref");
			query.setString("ref", locationCode);
			Location location = (Location) query.uniqueResult();
			commit();
			return location;
		} catch (Exception e) {
			rollback();
			return null;
		}
	}

}
