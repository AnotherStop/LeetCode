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
    public int maxDepth(TreeNode root) {
        
        return deepSearch(root, 1);
    }
    
    //return the depth of current value
    public int deepSearch(TreeNode node, int depth){
        
        if(node == null)
            return depth - 1;
            
        int left = deepSearch(node.left, depth+1);
        int right = deepSearch(node.right, depth+1);
        
        //return the largest value as depth of current value
        return (left > right) ? left : right;
    }
    
}
