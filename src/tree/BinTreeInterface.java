package tree;
public interface BinTreeInterface {

	/**
	 * calculates the maximum sum of the node values on a path from the root to any leaf
	 * @return maximum sum of the node values from the root to any leaf
	 */
	public abstract int calculateMaxSum();

	/**
	 * checks whether the tree is sorted 
	 * @return true, if the tree is sorted
	 */
	public abstract boolean isSorted();


	/**
	 * print all nodes of a tree according to the preorder
	 * using a generic stack
	 * not rekursive (but iterative) method 
	 */
	public abstract void depthFirst();

	/**
	 * removes a node with the given value from a sorted binary tree
	 * after that the binary tree is still sorted
	 * @param away given value to remove
	 */
	public abstract boolean removeNode(int away);

}