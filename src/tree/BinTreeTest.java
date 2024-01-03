package tree;

import org.junit.Test;

class BinTreeTest {

    BinNode f = new BinNode(1);
    BinNode g = new BinNode(3);
    BinNode h = new BinNode(2, f, g);
    BinNode i = new BinNode(5);
    BinNode j = new BinNode(4, h, i);
    BinNode k = new BinNode(8);
    BinNode l = new BinNode(9, k, null);
    BinNode m = new BinNode(7, j, l);
    BinTree abb1 = new BinTree(m);

    BinNode c = new BinNode(9);
    BinNode d = new BinNode(2);
    BinNode e = new BinNode(7);
    BinNode b = new BinNode(4, d, e);
    BinNode a = new BinNode(6, b, c);
    BinTree abb2 = new BinTree(a);

    @org.junit.jupiter.api.Test
    void removeNodeLeaf() {
        abb1.removeNode(3);
        abb1.depthFirst();
        System.out.println();
    }
    @org.junit.jupiter.api.Test
    void removeNodeNodeWithOneChild(){
        abb1.removeNode(9);
        abb1.depthFirst();
        System.out.println();
    }
    @org.junit.jupiter.api.Test
    void removeNodeWithTwoChildren(){
        abb1.removeNode(4);
        abb1.depthFirst();
        System.out.println();
    }
    @org.junit.jupiter.api.Test
    void removeRoot(){
        abb1.removeNode(7);
        abb1.depthFirst();
        System.out.println();
    }
    @org.junit.jupiter.api.Test
    void removeNotIncludedNumber(){
        abb1.removeNode(10);
        abb1.depthFirst();
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void removeUnsortedTree(){
        abb2.removeNode(7);
        abb2.depthFirst();
        System.out.println();
    }
}