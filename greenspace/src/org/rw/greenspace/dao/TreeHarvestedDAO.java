/**
 * 
 */
package org.rw.greenspace.dao;

import java.util.List;

import org.rw.greenspace.orm.TreeHarvested;

/**
 * @author student
 * tree harvest access object 
 *
 */
public interface TreeHarvestedDAO {
	
	public TreeHarvested saveTreeHarvested(TreeHarvested treeHarvested);

	public TreeHarvested updateTreeHarvested(TreeHarvested treeHarvested);

	public TreeHarvested saveOrUpdateTreeHarvested(TreeHarvested treeHarvested);

	public boolean deleteTreeHarvested(TreeHarvested treeHarvested);

	public TreeHarvested getTreeHarvestedById(int id);

	public List<TreeHarvested> getAllTreeHarvesteds();

	public List<TreeHarvested> getTreeHarvestedByTreeHarvestedName(String treeHarvestedName);

}
