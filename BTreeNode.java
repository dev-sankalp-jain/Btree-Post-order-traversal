package BTree;

import java.util.Arrays;

public class BTreeNode {

    // keys in the node
    int[] keys;
    // child pointers of node
    BTreeNode[] ptr;
    // minimum degree
    int t;
    // store whether node is leaf or not
    boolean leaf;
    // Keys in the node
    int n;

    public BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        // maximum number of keys in a node is 2t-1
        this.keys = new int[2 * t - 1];
        // maximum number of childs in a node is number of keys + 1
        this.ptr = new BTreeNode[2 * t];

        this.n = 0;
    }

    @Override
    public String toString() {
        String str="[ ";
        for(int i=0;i<n;i++){
            str+=this.keys[i] + " ";
        }
        return str + "]" ;
    }

}
