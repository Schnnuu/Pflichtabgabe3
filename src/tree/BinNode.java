package tree;
public class BinNode extends BinTree {
    int data;
    BinNode left, right;

    //Konstruktoren
    BinNode(){
        left = right = null;
    }

    BinNode(int d) {
        data = d;
        left = right = null;
    }

    BinNode(int d, BinNode l, BinNode r) {
        data = d; left = l; right = r;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BinNode left) {
       this.left = left;
    }

    public void setRight(BinNode right) {
        this.right = right;
    }
}