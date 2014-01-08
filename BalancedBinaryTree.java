/*
 *Key point: the depth of the two subtree of "every" node never differ
 *  by more than 1.
 *
 * So, we should check the difference at every node, rather than checking
 * the depth of left and rigth subtree of root node. Otherwise, we'll miss
 * the test case like 1,2,2,3,#,#,3,4,#,#,4
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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        //calculate the depth of two subtrees
        int leftResult = deepSearch(root.left, 1);
        int rightResult = deepSearch(root.right, 1);
        
        //since subtree will return -1 if it self is unbalanced
        if(leftResult < 0 || rightResult < 0)
            return false;
        
        //balanced tree    
        if((leftResult == rightResult) || (leftResult == rightResult + 1) || (rightResult == leftResult + 1))
            return true;
            
        return false;
        
    }
    
    //return the depth of current node
    public int deepSearch(TreeNode node, int level){
        if(node == null)
            return level - 1;
        
        //recursively calculate depth    
        int left = deepSearch(node.left, level+1);
        int right = deepSearch(node.right, level+1);
        
        //if itself is unbalanced, return -1
        if(left < 0 || right < 0)
            return -1;
            
        int diff = left - right;
        diff = (diff > 0) ? diff : (-diff);
        //if difference of subtree are greater than 1, it's unbalanced
        if(diff > 1)
            return -1;
        
        //depth of current node
        int result = (left > right) ? left : right;
        
        return result;
        
    }
}