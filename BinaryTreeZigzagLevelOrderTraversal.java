/*
 *Key point: making sure how the zigzag traversal works,
 *  it decides the order of how we push child into stack
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(root == null)
            return result;
        
        //init two stacks
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        
        Stack<TreeNode> tempStack = null;
        
        TreeNode currentNode = null;
        ArrayList<Integer> currentLevel = new ArrayList<Integer>();
        
        st1.push(root);
        
        //indicator for even number level where we visit from right-side
        boolean evenLevel = true;
        
        //swap st1 and st2 when st1 is empty, so checking st1 is enough
        while(st1.empty() == false){
            currentNode = st1.pop();
            currentLevel.add(currentNode.val);
            
            //the order of pushing into stack depends on the number of level
            if(evenLevel == true){
                //pushing left child first, so that visitting it later
                if(currentNode.left != null)
                    st2.push(currentNode.left);
                if(currentNode.right != null)
                    st2.push(currentNode.right);
            }
            else{
                //pushing right child first, so that visitting it later
                if(currentNode.right != null)
                    st2.push(currentNode.right);
                if(currentNode.left != null)
                    st2.push(currentNode.left);
            }
                
            if(st1.empty() == true){
                //clone() method return Object, so casting is necessary
                result.add((ArrayList<Integer>)currentLevel.clone());
                currentLevel.clear();
                
                //change number of level
                evenLevel = !evenLevel;
                
                //swap reference of stack
                tempStack = st1;
                st1 = st2;
                st2 = tempStack;
            }    
            
        }
        
        return result;
    }
}