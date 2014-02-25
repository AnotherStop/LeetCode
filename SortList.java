/*
 * Key point: mergesort O(nlogn)
 *   implementing mergesort on list, 
 *   using fast/slow pointer to find middle index,
 *   split to two independent lists from slow and slow.next
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head){
        
        //if list has no node or only one nodes, already sorted
        if(head == null || head.next == null)
            return head;
        
        //list has only two nodes, merge them    
        else if(head.next.next == null){
            ListNode newHead = head.next;
            head.next = null;
            return merge(head, newHead);
        }
            
        else{
            //find middle index
            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            
            //split to two lists
            ListNode newHead = slow.next;
            slow.next = null;
            
            //if left or right list has more than one nodes, call mergesort() recursively
            //list is different from array, 
            //we need to update head and newHead with the return values of mergesort()
            if(head.next != null)
                head = mergeSort(head);
            if(newHead.next != null)
                newHead = mergeSort(newHead);
            
            //merge sorted left and right lists    
            return merge(head, newHead);
        }
        
    }
    
    public ListNode merge(ListNode left, ListNode right){
        if(left == null)
            return right;
        if(right == null)
            return left;
            
        ListNode head = null;
        if(left.val < right.val){
            head = left;
            left = left.next;
        }
        else{
            head = right;
            right = right.next;
        }
        
        ListNode current = head;
        current.next = null;
        
        while(left != null && right != null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }
            else{
                current.next = right;
                right = right.next;
            }
            
            current = current.next;
        }
        
        if(left != null)
            current.next = left;
        if(right != null)
            current.next = right;
            
        return head;
    }
}