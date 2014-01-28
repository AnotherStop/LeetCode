/* 
* @Author: reinvent-the-wheel
* @Last Modified time: 2014-01-28 15:11:30
*/

/*
 * Recursive solution
 * Reference: http://leetcode.com/2010/03/first-on-site-technical-interview.html
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
            
        if(root.left != null)
            root.left.next = root.right;
            
        if(root.right != null)
            root.right.next = (root.next != null) ? (root.next.left) : null;
            
        connect(root.left);
        connect(root.right);
        
    }
}


/*------------------------------------*/


/*
 * non-recursive solution
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
            
        if(root.left == null || root.right == null)
            return;
            
        TreeLinkNode lastRowRunner = root;
        TreeLinkNode currentRowRunner = root.left;
        TreeLinkNode currentRowHead = root.left;
        
        while(currentRowRunner != null){
            if(currentRowRunner == lastRowRunner.left){
                currentRowRunner.next = lastRowRunner.right;
                currentRowRunner = currentRowRunner.next;
            }
            
            if(currentRowRunner == lastRowRunner.right){
                currentRowRunner.next = (lastRowRunner.next != null) ? (lastRowRunner.next.left) : null;
                currentRowRunner = currentRowRunner.next;
                lastRowRunner = lastRowRunner.next;
            }
            
            if(lastRowRunner == null){
                lastRowRunner = currentRowHead;
                currentRowHead = currentRowHead.left;
                currentRowRunner = currentRowHead;
            }
        }
        
    }
}