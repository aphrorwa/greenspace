/**
 * 
 */
package org.rw.greenspace.dao;

import java.util.List;

import org.rw.greenspace.orm.Seed;
import org.rw.greenspace.orm.Tree;

/**
 * @author student
 *
 */
public interface SeedDAO {
	
	public Seed saveSeed(Seed seed);

	public Seed updateSeed(Seed seed);

	public Seed saveOrUpdateSeed(Seed seed);

	public boolean deleteSeed(Seed seed);

	public Seed getSeedById(int id);

	public List<Seed> getAllSeeds();

	public List<Seed> getSeedByTree(Tree tree);
}
