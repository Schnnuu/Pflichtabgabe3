package tree;
public class BinTree implements BinTreeInterface{

    private BinNode root = null;
    BinTree() {
        root = null;
    }
    BinTree(BinNode r) {
        root = r;
    }


    /**
     * calculates the maximum sum of the node values on a path from the root to any leaf
     * @return maximum sum of the node values from the root to any leaf
     */
    @java.lang.Override
    public int calculateMaxSum() {
        return calculateMaxSum(root);
    }

    public int calculateMaxSum(BinNode node){
        if (node == null){
            return 0;
        }
        //two integers which call themselves to get the maxSum from their side
        int leftMax = calculateMaxSum(node.left);
        int rightMax = calculateMaxSum(node.right);

        //checks whether left or right side is bigger and adds the root value to it
        return Math.max(leftMax, rightMax) + node.data;
    }


    /**
     * Two Methods to locate the maximum and minimum value in a given Bin Tree
     * Both methods are helper methods for isSorted() Method
     */
    // A Method to get the maxValue of a binary tree
    private static int maxValue(BinNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int leftMax = maxValue(node.left);
        int rightMax = maxValue(node.right);

        return Math.max(node.data, Math.max(leftMax,rightMax));
    }

    // A Method to get the minValue of a binary tree
    private static int minValue(BinNode node){
        if(node == null){
            return Integer.MAX_VALUE;
        }
        int leftMin = minValue(node.left);
        int rightMin = minValue(node.right);

        return Math.min(node.data, Math.min(leftMin,rightMin));
    }


    /**
     * checks whether the tree is sorted
     * @return true, if the tree is sorted
     */
    @java.lang.Override
    public boolean isSorted() {
        return isSorted(root);
    }

    public boolean isSorted(BinNode node){
        if (node == null){
            return true;
        }

        // checks if the left node is smaller than the root
        if (node.left != null && maxValue(node.left) > node.data){
            return false;
        }

        //checks if the right node is bigger than the root
        if (node.right != null && minValue(node.right) < node.data){
            return false;
        }

        //checks if both sides are sorted correctly
        if (!isSorted(node.left) || !isSorted(node.right)){
            return false;
        }

        //returns true if all other conditions are met
        return true;
    }


    /**
     * print all nodes of a tree according to the preorder
     * using a generic stack
     * not rekursive (but iterative) method
     */
    @Override
    public void depthFirst() throws IllegalStateException{
        // If the tree is empty, throws Exception
        if (root == null)throw new IllegalStateException("Binary Tree is null!");

        // Create a stack to facilitate depth-first traversal
        StackGeneric<BinNode> stack = new StackGeneric<>();
        stack.push(root); // Start by pushing the root node onto the stack

        // Traverse the tree using a while loop until the stack is empty
        while (!stack.isEmpty()) {
            // Pop the top node from the stack
            BinNode node = stack.pop();

            // Print the data of the popped node (could be modified for different actions)
            System.out.print(node.data + " ");

            // Push the right child onto the stack (if exists) before the left child
            // This ensures the left child is processed first in depth-first traversal
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * removes a node with the given value from a sorted binary tree
     * after that the binary tree is still sorted
     * @param away given value to remove
     */
    @Override
    public boolean removeNode(int away) {
        // If the tree is empty, return false as there's nothing to remove
        if (root == null) {
            return false;
        }
        // Call the private recursive method to start the removal process
        root = removeNode(root, away);
        return true; // Return true indicating the removal was completed
    }

    // Private recursive method to remove a node with a given value
    private BinNode removeNode(BinNode currentNode, int away) {
        // If the current node is null, return it
        if (currentNode == null) {
            return currentNode;
        }

        // Check if the value to remove is less than or greater than the current node's value
        if (away < currentNode.data) {
            // If smaller, traverse left subtree
            currentNode.setLeft(removeNode(currentNode.left, away));
        } else if (away > currentNode.data) {
            // If larger, traverse right subtree
            currentNode.setRight(removeNode(currentNode.right, away));
        } else {
            // If the node to be removed is found

            // If the node has no left child, replace it with its right child
            if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                // If the node has no right child, replace it with its left child
                return currentNode.left;
            }

            // If the node has both left and right children
            // Find the minimum value node in the right subtree (successor)
            BinNode successor = findMin(currentNode.right);
            // Replace the current node's value with the successor's value
            currentNode.setData(successor.data);
            // Remove the successor node from the right subtree
            currentNode.setRight(removeNode(currentNode.right, successor.data));
        }
        // Return the current node after potential modifications
        return currentNode;
    }


    // Private method to find the node with the minimum value in a subtree
    private BinNode findMin(BinNode node) {
        // Traverse to the rightmost node in the subtree
        while (node.right != null) {
            node = node.right; // Move to the right child
        }
        return node; // Return the node with the minimum value
    }

}
