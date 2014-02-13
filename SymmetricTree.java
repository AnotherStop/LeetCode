/*
 * Key point: dfs
 * The left child's left subtree should be the same as right child's right subtreee and left child's right subtree should equal to right child's left subtree
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
            
        return dfsWorker(root.left, root.right);
    }
    
    public boolean dfsWorker(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
            
        boolean result = false;
        
        //value should be equal, then go deeper
        if(left != null && right != null && left.val == right.val)
            result = dfsWorker(left.left, right.right) && dfsWorker(left.right, right.left);
            
        return result;
    }
}