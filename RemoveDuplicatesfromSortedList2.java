/*
 *Key point: we need three pointers, because this's a 
 * singly-linked list, we need a "last" pointer to denote
 * the last element of "current"
 *
 *Key point: make sure runner isn't null before access runner.val
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
    
        //there's no duplicate for empty and one-node list
        if(head == null || head.next == null)
            return head;
    
        
        ListNode newHead = head;
        ListNode last = head;   //save last (potential) distinct element
        ListNode current = head;    //current element that we are examining
        ListNode runner = current.next;
    
    int repeatTimes = 0;
    
    while(runner != null){
        
        //check whether current element appears many times
        while (runner != null && current.val == runner.val){
            repeatTimes++;
            runner = runner.next;
        }
        
        //if current element appears many times
        if(repeatTimes > 0){
            
            //if we haven't found a distince element
            if(current == last){
                newHead = runner;
                last = runner;
            }
            else{ //we have found at least a distinct element earlier
                last.next = runner;
            }
            
            current = runner;
            repeatTimes = 0;
        }
        else{ //current element is a distinct element
        
            //if this's the first distinct element that we found
            if(current == last){
                current = runner;
            }
            else{ //we have found at least distinct element ealier
                last = last.next;
                current = current.next;
            }
        }
        
        if(runner != null)
            runner = runner.next;
    }
    
    return newHead;
    }
}