package BTree;

public class BSTNode {

    int key;
    BSTNode left, right;

    public BSTNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
