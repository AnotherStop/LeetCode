/*
 * Key point: dfs
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;

        //left and right pointers for the two arrays
        int preLeft = 0, inLeft = 0;
        int preRight = preorder.length-1, inRight = inorder.length-1;
        
        return dfsWorker(preorder, preLeft, preRight, inorder, inLeft, inRight);
    }
    
    public TreeNode dfsWorker(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        TreeNode root = new TreeNode(preorder[preLeft]);
        
        if(preLeft == preRight)
            return root;
        
        //get the corresponding index in inorder[]
        int inorderIndex = searchInorder(preorder[preLeft], inorder, inLeft, inRight);
        
        //the number of nodes in left and right subtree
        int leftNodes = inorderIndex - inLeft;
        int rightNodes = inRight - inorderIndex;
        
        //if left subtree has nodes
        if(inorderIndex != inLeft)
            root.left = dfsWorker(preorder, preLeft+1, preLeft+leftNodes, inorder, inLeft, inorderIndex-1);
        else
            root.left = null;
        
        //if right subtree has nodes    
        if(inorderIndex != inRight)
            root.right = dfsWorker(preorder, preRight-rightNodes+1, preRight, inorder, inorderIndex+1, inRight);
        else
            root.right = null;
            
        return root;
        
    }
    
    public int searchInorder(int target, int[] inorder, int inLeft, int inRight){
        for(int i = inLeft;i<=inRight;i++){
            if(target == inorder[i])
                return i;
        }
        
        return -1;
    }

}