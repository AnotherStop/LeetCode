/*
 * Key point: consider boundry condition
 *   eg. list of same length, different length, 0 length
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
        ListNode newHead = null;
        if(l1.val < l2.val){
            newHead = l1;
            l1 = l1.next;
            newHead.next = null;
        }
        else{
            newHead = l2;
            l2 = l2.next;
            newHead.next = null;
        }
        
        ListNode current = newHead;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
                current = current.next;
                current.next = null;
            }
            else{
                current.next = l2;
                l2 = l2.next;
                current = current.next;
                current.next = null;                
            }
        }
        
        if(l1 != null)
            current.next = l1;
        if(l2 != null)
            current.next = l2;
            
        return newHead;
    }
}