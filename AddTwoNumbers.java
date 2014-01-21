/*
 * Key point: handle the carry especially when the length
 *   of l1 and l2 are different and need an extra bit to
 *   store a carry
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        else if(l1 == null && l2 != null)
            return l2;
        else if(l1 != null && l2 == null)
            return l1;
            
        ListNode result = null;
        ListNode runner = null;
        
        int carry = 0;
        int digitValue = 0;
        int tempSum = 0;
        boolean firstDigit = true;
        
        //handle the common part of l1 and l2
        while(l1 != null && l2 != null){
            tempSum = carry + l1.val + l2.val;
            carry = tempSum / 10;
            digitValue = tempSum % 10;

            //first digit
            if(firstDigit == true){
                runner = new ListNode(digitValue);
                result = runner;
                firstDigit = false;
            }
            else{
                runner.next = new ListNode(digitValue);
                runner = runner.next;
            }
                
            l1 = l1.next;
            l2 = l2.next;
        }
        
        //if l1 and l2 are of same length
        if(l1 == null && l2 == null){
            if(carry == 0)
                return result;
            else{
                runner.next = new ListNode(carry);
                return result;
            }
        }
        
        //swap, to make sure l1 is longer than l2
        if(l1 == null){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        if(l2 == null){

            //link the remain part of l1 to the tail of result
            runner.next = l1;
            
            //if when l2 ends, carry is not 0
            while(carry != 0){
                tempSum = carry + l1.val;
                l1.val = tempSum % 10;
                carry = tempSum / 10;
                
                if(l1.next != null){
                    l1 = l1.next;
                }
                else{//reach the end of l1
                    if(carry != 0)
                        l1.next = new ListNode(carry);
                    carry = 0;
                }
                
            }
        }
            
        return result;

    }
}