/*
 * Key point: draw diagram, get() method of ArrayList
 *    Another solution is using Priority Queue
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)
            return null;
        
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        ListNode current = fakeHead;
        
        while(true){
            //index of the minimum value
            int minIndex = -1;
            for(int i = 0;i < lists.size();i++){
                if(lists.get(i) != null && (minIndex == -1 || lists.get(i).val < lists.get(minIndex).val))
                    minIndex = i;
            }
            
            if(minIndex == -1)
                break;
            else{
                current.next = lists.get(minIndex);
                current = current.next;
                lists.set(minIndex, lists.get(minIndex).next);
                current.next = null;    //this line isn't necessary, leave it to show a clear idea
            }
        }
        
        return fakeHead.next;
    }
}