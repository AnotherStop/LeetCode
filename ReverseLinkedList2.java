/*
 * Key point: draw diagram, consider all posible cases
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n)
            return head;
            
        if(m == 1){
            ListNode newHead = null;
            ListNode current = head;
            ListNode next = current.next;
            
            while(n > 0){
                current.next = newHead;
                newHead = current;
                current = next;

                if(next != null)
                    next = next.next;
                else
                    break;

                n--;
            }
            
            head.next = current;
            return newHead;
        }
        else{
            ListNode pre = head;
            for(int i = m;i>2;i--){
                pre = pre.next;
            }
            
            ListNode rangeEnd = pre.next;
            ListNode current = pre.next;
            ListNode next = current.next;

            //notice that in this condition, n>=m rather than n > 0
            while(n >= m){
                current.next = pre.next;
                pre.next = current;
                rangeEnd.next = next;
                current = next;

                if(next != null)
                    next = next.next;
                else
                    break;

                n--;
            }
            
            return head;
        }
    }
}