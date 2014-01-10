/*
 * Key point: fast/slow runner technique to find middle node, 
 *    time complexity is O(nlgn) which comes from f(n) = 2f(n/2) + cn
 *
 *  There is a O(n) solution that build the BST bottom-up 
 *    but it's hard to be implemented in java because of lacking passing by reference
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
        
        //init fast runner and slow runner    
        ListNode fast=head.next.next;
        ListNode slow=head;
        
        //partition the list from the middle, use the fast/slow runner technique
        //the slow pointer will be the prev of the middle node
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        //find the middle node
        ListNode parent=slow.next;

        //partition the list into left and right sublist
        slow.next=null;
        ListNode left=head;
        ListNode right=parent.next;
        parent.next=null;
        
        //make the middle node as the root, then apply the function
        //to the left part and the right part recursively
        TreeNode root=new TreeNode(parent.val);                                     
        root.left=sortedListToBST(left);            
        root.right=sortedListToBST(right);
        
        return root;
        
    }


}