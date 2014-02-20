/*
 * Key point: dfs, much like the 
 * Construct binary tree from preorder and inorder traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
            
        int inLeft = 0, postLeft = 0;
        int inRight = inorder.length-1, postRight = postorder.length-1;
        
        return dfsWorker(inorder, inLeft, inRight, postorder, postLeft, postRight);
    }
        
    public TreeNode dfsWorker(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight){
            TreeNode root = new TreeNode(postorder[postRight]);
            
            if(postLeft == postRight)
                return root;
            
            //find the corresponding index in inorder[]    
            int inorderIndex = searchInorder(postorder[postRight], inorder, inLeft, inRight);
            
            //number of nodes in left and right subtrees
            int leftNodes = inorderIndex - inLeft;
            int rightNodes = inRight - inorderIndex;
            
            //left subtree
            if(inorderIndex != inLeft)
                root.left = dfsWorker(inorder, inLeft, inorderIndex-1, postorder, postLeft, postLeft+leftNodes-1);
            else
                root.left = null;
                
            //right subtree    
            if(inorderIndex != inRight)
                root.right = dfsWorker(inorder, inorderIndex+1, inRight, postorder, postRight-rightNodes, postRight-1);
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