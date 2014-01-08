/*
 *Key point: recursive call start from root to node
 *
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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return doSum(root, sum);
    }
    
    public int doSum(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        
        //calculating the up-to-date sum
        sum*=10;
        sum+=root.val;
        
        //checking whether reaching a node, if so, return current sum
        if(root.left == null && root.right == null)
            return sum;
        else{
            //else, return the sum of left subtree and right subtree
            int leftSum = 0;
            int rightSum = 0;
        
            if(root.left != null)
                leftSum = doSum(root.left, sum);
            
            if(root.right != null)
                rightSum = doSum(root.right, sum);
            
            return leftSum + rightSum;
        }
    }
}