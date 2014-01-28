/* 
* @Author: reinvent-the-wheel
* @Last Modified time: 2014-01-28 17:40:39
*/

/*
 * My original non-recursive solution
 *  idea: allocate each available child of lastRowRunner to currentRowRunner.next
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
            
        if(root.left == null && root.right == null)
            return;
            
        TreeLinkNode lastRowRunner = root;
        TreeLinkNode currentRowHead = (root.left != null) ? root.left : root.right;
        TreeLinkNode currentRowRunner = currentRowHead;
        
        while(lastRowRunner != null){
            
            if(lastRowRunner.left != null && lastRowRunner.left != currentRowRunner){
                currentRowRunner.next = lastRowRunner.left;
                currentRowRunner = currentRowRunner.next;
                    
            }
            if(lastRowRunner.right != null && lastRowRunner.right != currentRowRunner){
                currentRowRunner.next = lastRowRunner.right;
                currentRowRunner = currentRowRunner.next;
            }
            
            lastRowRunner = lastRowRunner.next;
            
            if(lastRowRunner == null){
                lastRowRunner = currentRowHead;
                
                //find out the new currentRowHead
                while(currentRowHead.left == null && currentRowHead.right == null){
                    currentRowHead = currentRowHead.next;
                
                    if(currentRowHead == null)
                        return;
                }
                
                currentRowHead = (currentRowHead.left != null) ? currentRowHead.left : currentRowHead.right;
                currentRowRunner = currentRowHead;
            }
        }
    }
}