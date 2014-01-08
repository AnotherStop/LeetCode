/*
 *Key point: using Queue to do BFS
 * I use two queues to store nodes in current level and next level, 
 * after we process current level queue, simply swapping the reference
 * of current and next level queue can largely simplify the code
 *
 * There is solution only need one queue that using two variables to 
 * indicate the number of nodes in current level and next level
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(root == null)
            return result;
        
        //init two queues
        Queue<TreeNode> tempQueue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> tempQueue2 = new LinkedList<TreeNode>();
        
        Queue<TreeNode> helper = null;  //helper for swap the tempQueue1 and tempQueue2
        
        TreeNode currentNode = null;
        
        ArrayList<Integer> sameLevel = new ArrayList<Integer>();
        
        tempQueue1.add(root);
        
        //we can always concentrate on Queue1 because we'll swap them after process queue1
        while(tempQueue1.peek() != null){
            currentNode = tempQueue1.poll();
            sameLevel.add(currentNode.val);
            
            if(currentNode.left != null)
                tempQueue2.add(currentNode.left);
            if(currentNode.right != null)
                tempQueue2.add(currentNode.right);
            
            //if the current level has been processed
            if(tempQueue1.peek() == null){
                //add the current level to result
                result.add((ArrayList<Integer>)sameLevel.clone());  //clone() does shallow copy and return Object
                sameLevel.clear();
            
                //swap tempQueue1 and tempQueue2
                helper = tempQueue1;
                tempQueue1 = tempQueue2;
                tempQueue2 = helper;
            }

        }
        
        return result;
    }
}