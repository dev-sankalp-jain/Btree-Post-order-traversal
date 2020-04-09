package BTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BTree {

    BTreeNode root;
    int t;

    public BTree(int t) {
        this.t = t;
        root = new BTreeNode(t, true);
    }

    public static BTreeNode search(BTreeNode root, int key) {

        if (root == null) {
            return null;
        }
        int ndx = Arrays.binarySearch(root.keys, 0, root.n, key);

        if (ndx < 0) {
            BTreeNode node = root.ptr[-1 - ndx];
            return search(node, key);
        }
        return root;
    }

    public static void postOrderTraversal(BTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.leaf) {
            BSTNode bstroot = BST.sortedArraytoBST(root.keys, 0, root.n);
            BST.postOrderTraversal(bstroot);
            return;
        } else {
            int i = 0, j = 0;
            while (i < root.n) {
                postOrderTraversal(root.ptr[j++]);
                postOrderTraversal(root.ptr[j++]);
                System.out.print(root.keys[i++] + " ");
            }
        }

    }

    public static void levelOrderTraversal(BTreeNode root) {

        Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
        if (root == null) {
            return;
        }

        queue.add(root);
        int cnt = 0, j = 0;
        while (!queue.isEmpty()) {
            cnt++;
            BTreeNode node = (BTreeNode) queue.remove();
            if (!node.leaf) {
                System.out.print("{" + node + "} ");
            } else {
                System.out.print(node + " ");
            }
            for (int i = 0; i <= node.n && node.ptr[i] != null; i++) {
                queue.add(node.ptr[i]);
            }

        }
    }

    public void insert(int key) {

        BTreeNode oldRoot = root;

        // If Root is full
        if (oldRoot.n == (2 * t - 1)) {
            // create new root
            BTreeNode newRoot = new BTreeNode(t, false);
            root = newRoot;
            newRoot.n = 0;

            newRoot.ptr[0] = oldRoot;
            split(newRoot, 0);
            insert_non_full(newRoot, key);
        } else {
            insert_non_full(oldRoot, key);
        }
    }

    private void split(BTreeNode x, int i) {

        // x is the parent node
        // y is the current node, which will be split 
        // PART 1: allocate the Node
        BTreeNode z = new BTreeNode(t, false);
        BTreeNode y = x.ptr[i];
        z.leaf = y.leaf;
        z.n = t - 1; // min no of the nodes in the ROOT

        // PART 2: data transfer
        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[j + t];
        }

        // PART 3: Management of Pointers
        if (!y.leaf) {
            // if y is not leaf then we have to manage the pointer for it
            for (int j = 0; j < t; j++) {
                z.ptr[j] = y.ptr[j + t];
            }

        }
        y.n = t - 1; // update the no of nodes in the Y node

        // PART 4 : Transfer the (t-1) th element to parent node
        int j;
        for (j = x.n; j >= i + 1; j--) {
            x.ptr[j + 1] = x.ptr[j];
        }

        x.ptr[j + 1] = z;

        for (j = x.n - 1; j >= i; j--) {
            x.keys[j + 1] = x.keys[j];
        }

        x.keys[i] = y.keys[t - 1];
        x.n = x.n + 1;

    }

    private void insert_non_full(BTreeNode x, int key) {
        int i = x.n - 1; // get the no of keys stored in the node
        if (x.leaf == true) {
            //if the node is leaf node, add it to the proper position

            //search from the back, the position where to insert in the tree
            while (i >= 0 && key < x.keys[i]) {
                x.keys[i + 1] = x.keys[i]; // make space for the new key
                i = i - 1;
            }

            x.keys[i + 1] = key;
            x.n = x.n + 1; // increase the count of the keys in the tree
        } else {
            //it is Internal node
            //check for the proper position from where we have to go down to it's child

            while (i >= 0 && key < x.keys[i]) {
                i = i - 1;
            }
            i = i + 1; // move the pointer forward as we have to go for the pointer

            if (x.ptr[i].n == (2 * t - 1)) {
                // the child node of the current node is FULL,so we split the node now

                // split the node here
                split(x, i);
                // After the splitting, we would always find the position to insert on the right half of the node
                // so we search if, the key is greater or not.
                if (key > x.keys[i]) {
                    i = i + 1;
                }
            }
            insert_non_full(x.ptr[i], key);

        }

    }

    public static int heightOfTree(BTreeNode x) {
        if (x == null) {
            return 0;
        } else {
            return heightOfTree(x.ptr[0]) + 1;
        }
    }

}
