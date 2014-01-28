/* 
* @Author: reinvent-the-wheel
* @Date:   2014-01-28 11:57:05
* @Last Modified by:   b27lu
* @Last Modified time: 2014-01-28 12:02:44
*/

/*
 * Key point: two pointer technique
 *   create two list to store smaller node and greater than or equal
 *   to node, finally connect the two lists and return
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
    public ListNode partition(ListNode head, int x) {
        //create the head of two new lists
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);

        //pointer of the two new lists
        ListNode leftPointer = leftHead;
        ListNode rightPointer = rightHead;
        
        //scan the original list and add node to proper list
        //use head as the pointer of the original list
        while(head != null){

            if(head.val < x){
                leftPointer.next = head;
                leftPointer = leftPointer.next;
            }
            else{
                rightPointer.next = head;
                rightPointer = rightPointer.next;
            }
            
            head = head.next;

            //clear the end of new lists
            leftPointer.next = null;
            rightPointer.next = null;
        }
        
        //connect the two new lists
        leftPointer.next = rightHead.next;	//jump the new head of right list
        
        return leftHead.next;	//jump the head of left head
    }
}