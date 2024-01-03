package tree;
public class BinTree implements BinTreeInterface{

    private BinNode root = null;
    BinTree() {
        root = null;
    }
    BinTree(BinNode r) {
        root = r;
    }

    // A Method to get the maxValue of a binary tree
    static  int maxValue(BinNode k){
        if(k == null){
            return Integer.MIN_VALUE;
        }
        int leftMax = maxValue(k.left);
        int rightMax = maxValue(k.right);

        return Math.max(k.data, Math.max(leftMax,rightMax));
    }

    // A Method to get the minValue of a binary tree
    static  int minValue(BinNode k){
        if(k == null){
            return Integer.MAX_VALUE;
        }
        int leftMin = minValue(k.left);
        int rightMin = minValue(k.right);

        return Math.min(k.data, Math.min(leftMin,rightMin));
    }


    //a recursive method to calculate the MaxSum of a binary tree
    @java.lang.Override
    public int calculateMaxSum() {
        return calculateMaxSum(root);
    }

    public int calculateMaxSum(BinNode k){
        if (k == null){
            return 0;
        }
        //two integers which call themselves to get the maxSum from their side
        int leftMax = calculateMaxSum(k.left);
        int rightMax = calculateMaxSum(k.right);

        //checks whether left or right side is bigger and adds the root value to it
        return Math.max(leftMax, rightMax) + k.data;
    }

    // A recursive methode to check if a binary tree is sorted or not
    @java.lang.Override
    public boolean isSorted() {
        return isSorted(root);
    }
    public boolean isSorted(BinNode k){
        if (k == null){
            return true;
        }

        // checks if the left node is smaller than the root
        if (k.left != null && maxValue(k.left) > k.data){
            return false;
        }

        //checks if the right node is bigger than the root
        if (k.right != null && minValue(k.right) < k.data){
            return false;
        }

        //checks if both sides are sorted correctly
        if (!isSorted(k.left) || !isSorted(k.right)){
            return false;
        }

        //returns true if all other conditions are met
        return true;
    }

    //an iterativ method to print a binary tree to console with a generic stack
    //and in preorder
    @Override
    public void depthFirst() {
        if (root == null) {
            return;
        }

        StackGeneric<BinNode> stack = new StackGeneric<>();
        stack.push(root);

        //While-Loop that prints the current node until the stack is empty
        while (!stack.isEmpty()) {
            BinNode k = stack.pop();

            // Prints current node
            System.out.print(k.data + " ");

            // First we put the right child on the stack and then the left child
            // Last in, first out
            if (k.right != null) {
                stack.push(k.right);
            }
            if (k.left != null) {
                stack.push(k.left);
            }
        }
    }

    @Override
    public boolean removeNode(int value) {
        if (root == null) {
            return false;
        }
        root = removeNode(root, value);
        return true;
    }

    private BinNode removeNode(BinNode currentNode, int value) {
        if (currentNode == null) {
            return currentNode;
        }

        if (value < currentNode.data) {
            currentNode.setLeft(removeNode(currentNode.left, value));
        } else if (value > currentNode.data) {
            currentNode.setRight(removeNode(currentNode.right, value));
        } else {
            if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                return currentNode.left;
            }

            BinNode successor = findMin(currentNode.right);
            currentNode.setData(successor.data);
            currentNode.setRight(removeNode(currentNode.right, successor.data));
        }
        return currentNode;
    }

    private BinNode findMin(BinNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
