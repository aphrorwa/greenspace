/**
 * 
 */
package org.rw.greenspace.dao;

import java.util.List;

import org.rw.greenspace.orm.Tree;

/**
 * @author student
 * tree data access object
 *
 */
public interface TreeDAO {
	public Tree saveTree(Tree tree);

	public Tree updateTree(Tree tree);

	public Tree saveOrUpdateTree(Tree tree);

	public boolean deleteTree(Tree tree);

	public Tree getTreeById(int id);

	public List<Tree> getAllTrees();

	public Tree getTreeByTreeName(String treeName);

}
