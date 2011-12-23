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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author student
 *
 */
@Entity
@Table(name="tree_harvested")
public class TreeHarvested {
	
	private int id;
	private TreePlanted treePlanted;
	private int seedQuantity;
	private Date date;
	private Location location;
	private String harvesterName;
	private String observation;
	private User user;
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
	 * @return the treePlanted
	 */
	@ManyToOne
	public TreePlanted getTreePlanted() {
		return treePlanted;
	}
	/**
	 * @param treePlanted the treePlanted to set
	 */
	public void setTreePlanted(TreePlanted treePlanted) {
		this.treePlanted = treePlanted;
	}
	/**
	 * @return the seedQuantity
	 */
	public int getSeedQuantity() {
		return seedQuantity;
	}
	/**
	 * @param seedQuantity the seedQuantity to set
	 */
	public void setSeedQuantity(int seedQuantity) {
		this.seedQuantity = seedQuantity;
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
	 * @return the harvesterName
	 */
	public String getHarvesterName() {
		return harvesterName;
	}
	/**
	 * @param harvesterName the harvesterName to set
	 */
	public void setHarvesterName(String harvesterName) {
		this.harvesterName = harvesterName;
	}
	/**
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}
	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}
	/**
	 * @return the user
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the location
	 */
	@ManyToOne
	//@JoinColumn(name="tree_harvested_id")
	public Location getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

}
