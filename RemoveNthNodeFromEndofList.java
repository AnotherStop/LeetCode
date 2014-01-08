/*
 *Key point: runner technique
 * I tried to use recursive call to get the end of list, but the
 * runner technique is much easier. 
 *
 * Keep runner "n steps" ahead of the current, can easily find the
 * nth last element
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
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode current = head;
        ListNode runner = head;
        
        int i;
        //move the runner "n steps" ahead current
        for(i = n;i>=0;i--){
            if(runner != null)
                runner = runner.next;
            else 
                return head.next;
        }
        
        //move current and runner ahead together, until runner reach the end
        while(runner != null ){
            current = current.next;
            runner = runner.next;
        }
        
        //the next element of current is the one to be deleted
        current.next = current.next.next;
        
        return head;
        
    }
    
}