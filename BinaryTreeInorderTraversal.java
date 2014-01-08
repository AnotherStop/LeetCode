/*
 * Key point: Much like the preorder traversal, the only differenence is 
 *    where we add the root node to the result ArrayList, namely the 
 *    location of ```result.add(root.val);```
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //at here, if I didn't specify as "Stack<TreeNode>",
        //then, I have to cast when pop() from stack
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        //iterative solution
        while(root != null || st.empty() == false){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
                root = st.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        
        return result;
    }        
}