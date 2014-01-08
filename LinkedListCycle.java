/*
 *Key pointer: fast runner/slow runner technique
 *
 * Another solution is that reversing the linked list and checking whether
 * the reversed list ends with head. If so, it has a cycle. Finally, reversing
 * the list again to restore the original list. It costs O(n), but the coefficient
 * is bigger than the runner technique
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
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null){
            return false;
        }
        
        ListNode fastRunner = head.next;
        ListNode slowRunner = head;
        
        //fastRunner moves two steps and slowRunner moves one steps
        //if there is a cycle, fastRunner will finally catch up slowRunner
        while(fastRunner.next != null && fastRunner.next.next != null){
            
            if(fastRunner == slowRunner)
                return true;
                
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }
        
        return false;

    }
}