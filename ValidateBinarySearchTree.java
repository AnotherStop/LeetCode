/*
 * Key point: dfs, pass the range for child's value down
 * 
 *   A common mistake is Assume that the current node’s value is k. 
 *   Then for each node, check if the left node’s value is 
 *   less than k and the right node’s value is greater than k. 
 *   If all of the nodes satisfy this property, then it is a BST.
 *
 * Lesson: max and min int in Java is Integer.MAX_VALUE and Integer.MIN_VALUE
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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return dfsWorker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean dfsWorker(TreeNode root, int min, int max){
        if(root.val <= min || root.val >= max)
            return false;
            
        boolean leftResult = true;
        boolean rightResult = true;
        
        if(root.left != null)
            leftResult = dfsWorker(root.left, min, root.val);
            
        if(root.right != null)
            rightResult = dfsWorker(root.right, root.val, max);
            
        return leftResult & rightResult;
    }
    
}