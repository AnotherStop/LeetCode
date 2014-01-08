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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        //make sure p and q are not null
        if(p == null && q == null)
            return true;
        else if(p == null && q != null)
            return false;
        else if(p != null && q == null)
            return false;
        else
            return searchTree(p, q);
    }
    
    public boolean searchTree(TreeNode p, TreeNode q){
        boolean result = true;
        
        //if value are same, we look up further
        if(p.val == q.val){
            
            //recursive checking left child tree
            if(p.left != null && q.left != null){
                result = searchTree(p.left, q.left);
                if(result == false)
                    return false;
            }
            else if(p.left != q.left)
                return false;
            
            //recursive checking right child tree    
            if(p.right != null && q.right != null){
                result = searchTree(p.right, q.right);
                if(result == false)
                    return false;
            }
            else if(p.right != q.right)
                return false;
;
        }
        else    //value are different, can't be same tree 
            return false;
        
        //if they are not same tree, already return before    
        return true;
    }
}