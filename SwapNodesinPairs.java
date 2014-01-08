/*
 *key point: swap current pair of node is easy, but never forget
 * link the last node of the last pair to the first node the swapped pair.
 * This is always the crucial point of most operation on singly-linked list.
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
    public ListNode swapPairs(ListNode head) {
        
        //if list is empty or only has one node, return
        if(head == null || head.next == null)
            return head;
        
        ListNode last = null;   //refer to last node of last pair
        ListNode current = head;
        ListNode runner = head.next;
        ListNode holder = head.next.next;   //holder for first node of next pair
        ListNode temp = null; 
        
        boolean foundHead = false;  //flag to show whether we have done first pair
        boolean allWorkDone = false;   //flag to show whether all works have done
        
        while(allWorkDone == false){
            
            //swap the pair of node
            current.next = runner.next;
            runner.next = current;
            
            //remain the reference of current and runner
            temp = current;
            current = runner;
            runner = temp;
            
            if(foundHead == false){
                head = current;
                last = runner;  //initial the "last" reference
                foundHead = true;   //don't forget to set flag
            }
            else{
                last.next = current;
                last = runner;
            }
            
            //checking whether we reach the end of the list
            if(holder == null || holder.next == null){
                allWorkDone = true;
            }
            else{
                //if not, move forward
                for(int i =2; i>0; i--){
                    current = current.next;
                    runner = runner.next;
                    holder = holder.next;
                }
            }
            
        }
        
        return head;
        
    }
}