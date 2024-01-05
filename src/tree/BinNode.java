package tree;
// Class representing a node in a binary tree
public class BinNode extends BinTree {
    int data; // Data stored in the node
    BinNode left, right; // References to left and right children

    // Constructors for BinNode

    // Default constructor initializes left and right children as null
    BinNode() {
        left = right = null;
    }

    // Constructor to create a node with given data and both children as null
    BinNode(int d) {
        data = d;
        left = right = null;
    }

    // Constructor to create a node with given data, left child, and right child
    BinNode(int d, BinNode l, BinNode r) {
        data = d;
        left = l;
        right = r;
    }

    // Setter methods to modify node attributes

    // Set data for the node
    public void setData(int data) {
        this.data = data;
    }

    // Set the left child for the node
    public void setLeft(BinNode left) {
        this.left = left;
    }

    // Set the right child for the node
    public void setRight(BinNode right) {
        this.right = right;
    }
}
