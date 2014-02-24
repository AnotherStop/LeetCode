/*
 * Key point: 
 *      1.common solution: insert a copy after each 
 *        original node(ignore random pointer now), then copy random pointer,
 *        finally, split the original list and copied list
 *
 *      2.HashMap Solution: use a HashMap<RandomListNode,RandomListNode> to 
 *        construct a key value pair between original node and new copied node,
 *        then, copy the next and random pointer accordingly
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;
            
        //insert a copy after each original node (ignore random pointer now)    
        RandomListNode current = head;    
        while(current != null){
            RandomListNode copy = new RandomListNode(current.label);
            copy.next = current.next;
            current.next = copy;
            current = current.next.next;
        }
        
        //copy random pointer
        current = head;
        while(current != null){

            if(current.random != null) //take care, random pointer may be null
                current.next.random = current.random.next;
            else
                current.next.random = null;
                
            current = current.next.next;
        }
        
        //split original list and copy list
        current = head;
        RandomListNode newHead = current.next;
        RandomListNode newCurrent = newHead;
        while(newCurrent != null){
            current.next = newCurrent.next;
            
            if(newCurrent.next != null)
                newCurrent.next = newCurrent.next.next;
            
            current = current.next;
            newCurrent = newCurrent.next;
        }
        
        return newHead;
    }
}

/*
 * HashMap Solution
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;
        
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode current = head;
        while(current != null){
            hm.put(current, new RandomListNode(current.label));
            current = current.next;
        }
        
        current = head;
        while(current != null){
            hm.get(current).next = hm.get(current.next);
            hm.get(current).random = hm.get(current.random);
            current = current.next;
        }
        
        return hm.get(head);
    }
}