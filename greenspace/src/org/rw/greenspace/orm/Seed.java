/**
 * 
 */
package org.rw.greenspace.orm;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.rw.greenspace.orm.User;

/**
 * @author student
 *
 */
@Entity
@Table(name="seed")
public class Seed {
	
	private int id;
	private Date date;
	private int seedQuantity;
	private List<Tree> trees;
	private List<Location> locations;
	private User user;
	private List<TreePlanted> treePlants;
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
	 * @return the seedQuantity
	 */
	@Column(nullable=false)
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
	 * @return the tree
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="seed")
	public List<Tree> getTrees() {
		return trees;
	}
	/**
	 * @param tree the tree to set
	 */
	public void setTrees(List<Tree> trees) {
		this.trees = trees;
	}
	/**
	 * @return the location
	 */
	@ManyToMany
	@JoinTable(name="location_seed", joinColumns={@JoinColumn(name="seed_id")}, inverseJoinColumns={@JoinColumn(name="location_id")})
	public List<Location> getLocations() {
		return locations;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	/**
	 * @return the user
	 */
	@ManyToOne
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
	 * @return the treePlants
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="seed")
	public List<TreePlanted> getTreePlants() {
		return treePlants;
	}
	/**
	 * @param treePlants the treePlants to set
	 */
	public void setTreePlants(List<TreePlanted> treePlants) {
		this.treePlants = treePlants;
	}
	
}
