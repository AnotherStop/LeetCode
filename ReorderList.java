/*
 * Key point: fast/slow runner technique to find the middle node
 *       split to two lists from middle node
 *       reverse the second list
 *       merge the first list with the 
 *         reversed list, beginning with the original head
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
         
        //find the middle node    
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the second list
        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverseList(newHead);
        
        //merge the two lists
        ListNode current = head;
        ListNode newCurrent = newHead;        
        while(current != null && newCurrent != null){
            ListNode next = current.next;
            ListNode newNext = newCurrent.next;
            
            current.next = newCurrent;
            newCurrent.next = next;
            
            current = next;
            newCurrent = newNext;
        }

    }
    
    //function for reversing list
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode newHead = null;
        ListNode current = head;
        
        while(current != null){
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        
        return newHead;
    }
}