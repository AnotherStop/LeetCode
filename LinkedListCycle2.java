/*
 *Key point: same as problem Linked List Cycle, using fast runner/slow runner 
 * to detect cycle. If so, slowRunner == fastRunner is a node in the cycle.
 * Then, detecting the length of cycle. Finally, moving the two runners, one is 
 * cycleLength steps ahead of the other, until one's next equals to the other
 *
 *Lesson: never forget increment whenever using while loop !!!
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
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode fastRunner = head.next;
        ListNode slowRunner = head;
        boolean hasCycle = false;
        
        //fastRunner moves two steps and slowRunner moves one steps
        //if there is a cycle, fastRunner will finally catch up slowRunner
        while(fastRunner.next != null && fastRunner.next.next != null){
            
            if(fastRunner == slowRunner){
                hasCycle = true;
                break;
            }
                
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }
        
        if(hasCycle == false)
            return null;
        
        //detect the length of cycle    
        int cycleLength = 0;
        ListNode detector = slowRunner.next;
        while(slowRunner != detector){
            cycleLength++;
            detector = detector.next;
        }
    
        //move runner cycleLength steps ahead of holder    
        ListNode holder = head;
        ListNode runner = head;
        while(cycleLength != 0){
            runner = runner.next;
            cycleLength--;  //using while loop, never forget increment
        }
        
        //move runner and holder together
        while(runner.next != holder){
            runner = runner.next;
            holder = holder.next;
        }
        
        return holder;

    }
}