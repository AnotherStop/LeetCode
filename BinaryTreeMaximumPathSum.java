/*
 * Key point: dfs, java use array to pass-by-reference
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
    public int maxPathSum(TreeNode root) {
       //java only has pass by value mechanism, use array to solve it
       int[] max = new int[1];
       max[0] = Integer.MIN_VALUE;
       
       dfsWorker(root, max);
       return max[0];
    }
    
    public int dfsWorker(TreeNode root, int[] max){
        if(root == null)
            return 0;
            
        int leftSum = dfsWorker(root.left, max);
        int rightSum = dfsWorker(root.right, max);
        //no matter left or right path, root has to be included; otherwise, path is cut off
        int partialSum = Math.max(root.val, Math.max(root.val+leftSum, root.val+rightSum));
        
        max[0] = Math.max(max[0], Math.max(partialSum, root.val+leftSum+rightSum));
        return partialSum;
    }
}