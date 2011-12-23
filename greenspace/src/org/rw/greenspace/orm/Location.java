/**
 * 
 */
package org.rw.greenspace.orm;

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

/**
 * @author student
 *
 */
@Entity
@Table(name="location")
public class Location {
	
	private int id;
	private String locationCode;
	private String locationName;
	private String locationDescription;
	private List<TreePlanted> treePlants;
	private List<TreeHarvested> treeHarvesteds;
	private List<Seed> seeds;
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
	 * @return the locationCode
	 */
	public String getLocationCode() {
		return locationCode;
	}
	/**
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	/**
	 * @return the locationName
	 */
	@Column(nullable=false)
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/**
	 * @return the locationDescription
	 */
	public String getLocationDescription() {
		return locationDescription;
	}
	/**
	 * @param locationDescription the locationDescription to set
	 */
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	/**
	 * @return the treePlants
	 */
	@OneToMany
	public List<TreePlanted> getTreePlants() {
		return treePlants;
	}
	/**
	 * @param treePlants the treePlants to set
	 */
	public void setTreePlants(List<TreePlanted> treePlants) {
		this.treePlants = treePlants;
	}
	/**
	 * @return the seed
	 */
	@ManyToMany
	@JoinTable(name="location_seed", joinColumns={@JoinColumn(name="location_id")}, inverseJoinColumns={@JoinColumn(name="seed_id")})
	public List<Seed> getSeeds() {
		return seeds;
	}
	/**
	 * @param seed the seed to set
	 */
	public void setSeeds(List<Seed> seeds) {
		this.seeds = seeds;
	}
	/**
	 * @return the treeHarvs
	 */
	@OneToMany
	public List<TreeHarvested> getTreeHarvesteds() {
		return treeHarvesteds;
	}
	/**
	 * @param treeHarvs the treeHarvs to set
	 */
	public void setTreeHarvesteds(List<TreeHarvested> treeHarvesteds) {
		this.treeHarvesteds = treeHarvesteds;
	}
}
