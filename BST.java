package BTree;
public class BST {

    // preventing  creation of objects
    private BST() {
    
    }
    
    public static BSTNode sortedArraytoBST(int keys[], int start, int end){
        
        if(keys==null || keys.length==0){
            return null;
        }
        else{
            return createBST(keys, start, end-1);
        }
        
    }
    
    private static BSTNode createBST(int keys[],int left,int right){
        
        if(left>right ){
            return null;
        }
        int mid = left + (right-left)/2;
        
        BSTNode root = new BSTNode(keys[mid]);
        root.left =  createBST(keys, left, mid-1);
        root.right = createBST(keys, mid+1, right);
        return root;
    }
    
    public static void postOrderTraversal(BSTNode root){
        if(root == null){
            return;
        }
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         
         System.out.print(root.key + " ");
    }
    
}
