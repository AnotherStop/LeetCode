/*
 *Key point: depth first search
 *
 * if one child of a node is null, the depth of the node is determined
 * by another node
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
    public int minDepth(TreeNode root) {
        return deepSearch(root, 1);
    }
    
    //return depth of current depth
    public int deepSearch(TreeNode node, int depth){
        if(node == null)
            return depth - 1;
        
        //leaf node    
        if(node.left == null && node.right == null)
            return depth;
        
        int left = -1;
        int right = -1;
        
        //recursive search on left node
        if(node.left != null)    
            left = deepSearch(node.left, depth + 1);
        
        //recursive search on right node    
        if(node.right != null)    
            right = deepSearch(node.right, depth + 1);
        
        //determine depth of current node    
        if(node.left == null)  
            return right;
        else if(node.right == null)
            return left;
        else
            return (left < right) ? left : right;
        
    }
}