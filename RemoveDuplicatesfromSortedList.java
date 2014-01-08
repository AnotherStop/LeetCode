/*
 *Key point: if runner is null, we can't access runner.val
 * namely, null has no attribute, attempting to access leads to runtime error
 *
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
    public ListNode deleteDuplicates(ListNode head) {
        
        //if list is empty or only one node, simply return
        if(head == null || head.next == null){
            return head;
        }
        
        //the two pointers technique is name runner technique in "CICT 150"
        ListNode current = head;
        ListNode runner = head.next;
        
        while(runner != null){
            
            //checking "runner != null" again at here,
            //otherwist, runner.val is invalid when runner is null
            while(runner != null && current.val == runner.val)
                runner = runner.next;
            
            current.next = runner;
            
            if(runner != null){
                current = runner;
                runner = runner.next;
            }
        }
        
        return head;
    }
}