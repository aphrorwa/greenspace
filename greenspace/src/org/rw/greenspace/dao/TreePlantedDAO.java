/**
 * 
 */
package org.rw.greenspace.dao;

import java.util.List;

import org.rw.greenspace.orm.TreePlanted;

/**
 * @author student
 * tree planted access object
 *
 */
public interface TreePlantedDAO {
	
	public TreePlanted saveTreePlanted(TreePlanted treePlanted);

	public TreePlanted updateTreePlanted(TreePlanted treePlanted);

	public TreePlanted saveOrUpdateTreePlanted(TreePlanted treePlanted);

	public boolean deleteTreePlanted(TreePlanted treePlanted);

	public TreePlanted getTreePlantedById(int id);

	public List<TreePlanted> getAllTreePlanteds();

	public List<TreePlanted> getTreePlantedByTreePlantedName(String treePlantedName);


}
