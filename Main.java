package BTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static void TreeActions(int arr[], BTree tree) {

        System.out.println("Data :");
        for (int a : arr) {
            System.out.print(a + " ");
            tree.insert(a);
        }
        System.out.print("\n---------------------------------------------------------------");
        System.out.println("\nBtree Height:");
        System.out.println(BTree.heightOfTree(tree.root));
        System.out.print("---------------------------------------------------------------");
        System.out.println("\nLevel Order Traversal:");
        System.out.println(" [x]   represents x is leaf node");
        System.out.println("{[x]}  represents x is non - leaf node");
        BTree.levelOrderTraversal(tree.root);
        System.out.print("\n---------------------------------------------------------------");

        System.out.println("\nPost Order Traversal:");

        BTree.postOrderTraversal(tree.root);
        System.out.println("\n\n*************************************************************");

    }

    public static void main(String[] args) throws Exception {
        try {

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            int ch = -1;
            while (ch != 0) {
                System.out.println("1.Run demo Tree\n2.Create own Tree\n0.Terminate");
                System.out.println("*************************************************************");
                ch = Integer.parseInt(br.readLine());
                BTree tree;
                int arr[];
                switch (ch) {
                    case 0:
                        break;
                    case 1:
                        arr = new int[]{10, 4, 12, 14, 25, 20, 5, 6, 8, 13};
                        tree = new BTree(2);
                        TreeActions(arr, tree);
                        break;
                    case 2:
                        System.out.println("Enter minimum degree(t):");
                        int t = Integer.parseInt(br.readLine());
                        System.out.println("---------------------------------------------------------------");

                        System.out.println("Enter input space seprated keys:");
                        String str[] = br.readLine().split(" ");
                        System.out.println("---------------------------------------------------------------");

                        tree = new BTree(t);
                        arr = new int[str.length];
                        for (int i = 0; i < arr.length; i++) {
                            arr[i] = Integer.parseInt(str[i]);
                        }
                        TreeActions(arr, tree);
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
