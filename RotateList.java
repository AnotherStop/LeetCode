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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || n == 0)
            return head;
        
        //get the length and tail of the list    
        int length = 1;
        ListNode temp = head;
        while(temp.next != null){
            length++;
            temp = temp.next;
        }
        
        ListNode tail = temp;
        
        if(n % length == 0)
            return head;
        else
            n = n % length;
        
        //get the pointer before new head    
        int i = length - n - 1;
        temp = head;
        while(i > 0){
            temp = temp.next;
            i--;
        }
        
        //move last n nodes to the head of list
        ListNode newHead = temp.next;
        temp.next = null;
        tail.next = head;
        
        return newHead;
    
    }
}