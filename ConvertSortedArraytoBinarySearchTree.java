/*
 *Key point: binary search
 *    if there's explicit constructor, the default one isn't available
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
    public TreeNode sortedArrayToBST(int[] num) {
        
        int length = num.length;
        //handle null pointer and empty array
        if(num == null || length == 0)
            return null;
        
        return realWorker(num, 0, length - 1);
    }
    
    public TreeNode realWorker(int[] num, int begin, int end){
        int mid = (begin + end + 1) / 2;
        
        //init a new node
        TreeNode node = new TreeNode(0);
        node.val = num[mid];
        
        if(begin <= mid - 1)
            node.left = realWorker(num,begin,mid-1);
        else
            node.left = null;
            
        if(mid+1 <= end)
            node.right = realWorker(num,mid+1,end);
        else
            node.right = null;
            
        return node;
    }
}