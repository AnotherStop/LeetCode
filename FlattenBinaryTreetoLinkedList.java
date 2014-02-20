/*
 * Key point: recursive solution, in-place, preorder
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
    public void flatten(TreeNode root) {

        recursiveWorker(root);

    }
    
    public TreeNode recursiveWorker(TreeNode root){
        if(root == null || (root.left == null && root.right == null))
            return root;
         
        //last node of flatted left-subtree    
        TreeNode leftEnd = recursiveWorker(root.left);

        //last node of flatted right-subtree
        TreeNode rightEnd = recursiveWorker(root.right);

        //connect left subtree and right subtree
        if(leftEnd != null){
            leftEnd.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        //return the last node after we connect left and right subtree
        if(rightEnd != null)
            return rightEnd;
        else
            return leftEnd;
    }
}