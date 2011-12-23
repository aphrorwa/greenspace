/**
 * 
 */
package org.rw.greenspace.orm;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author student
 *
 */
@Entity
@Table(name="tree_planted")
public class TreePlanted {
	
	private int id;
	private int treeQuantity;
	private Date date;
	//private Location location;
	//private User user;
	private Seed seed;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the seedQuantity
	 */
	public int getTreeQuantity() {
		return treeQuantity;
	}
	/**
	 * @param seedQuantity the seedQuantity to set
	 */
	public void setTreeQuantity(int TreeQuantity) {
		this.treeQuantity = TreeQuantity;
	}
	/**
	 * @return the date
	 */
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the user
	 */
//	@ManyToOne
//	@JoinColumn(name="user_id")
//	public User getUser() {
//		return user;
//	}
	/**
	 * @param user the user to set
	 */
//	public void setUser(User user) {
//		this.user = user;
//	}
	/**
	 * @return the seed
	 */
	@ManyToOne
	@JoinColumn(name="seed_id")
	public Seed getSeed() {
		return seed;
	}
	/**
	 * @param seed the seed to set
	 */
	public void setSeed(Seed seed) {
		this.seed = seed;
	}
	/**
	 * @return the location
	 */
//	@ManyToOne
//	@JoinColumn(name="location_id")
//	public Location getLocation() {
//		return location;
//	}
	/**
	 * @param location the location to set
	 */
//	public void setLocation(Location location) {
//		this.location = location;
//	}
	
}
