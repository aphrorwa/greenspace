/**
 * 
 */
package org.rw.greenspace.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author student
 *
 */
@Entity
@Table(name="tree")
public class Tree {
	
	private int id;
	private String treeName;
	private String treeDescription;
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
	 * @return the treeName
	 */
	@Column(nullable=false)
	public String getTreeName() {
		return treeName;
	}
	/**
	 * @param treeName the treeName to set
	 */
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	/**
	 * @return the treeDescription
	 */
	public String getTreeDescription() {
		return treeDescription;
	}
	/**
	 * @param treeDescription the treeDescription to set
	 */
	public void setTreeDescription(String treeDescription) {
		this.treeDescription = treeDescription;
	}
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

}
