/**
 * 
 */
package org.rw.greenspace.dao;

import java.util.List;

import org.rw.greenspace.orm.Location;

/**
 * @author student
 * location data access object
 *
 */
public interface LocationDAO {
	
	public Location saveLocation(Location location);

	public Location updateLocation(Location location);

	public Location saveOrUpdateLocation(Location location);

	public boolean deleteLocation(Location location);

	public Location getLocationById(int id);

	public List<Location> getAllLocations();

	public Location getLocationByLocationCode(String locationCode);

}
