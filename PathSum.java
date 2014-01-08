/*
 *Key point: depth first search
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        
        //recursive call, initial currentSum is 0
        return checkSum(root,sum,0);    

    }
    
    //argument currentSum pass the path sum before the root node
    public boolean checkSum(TreeNode root, int sum, int currentSum){
        
        //up-to-date path sum
        currentSum = currentSum + root.val;
        
        //if we reach a leaf
        if(root.left == null && root.right == null)
            if(currentSum == sum)
                return true;
            else
                return false;
        
        //recursive call on left and right subtree    
        boolean left = false;
        boolean right = false;
        if(root.left != null)
             left = checkSum(root.left,sum,currentSum);
        if(root.right != null)
             right = checkSum(root.right,sum,currentSum);
        
        //if both paths don't equal to sum, return false    
        if(left == false && right == false)
            return false;
            
        return true;
    }
}