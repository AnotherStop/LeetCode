/*
 *Key point: As mentioned in the question's node, recursive solution is trivial,
 * To conceive the non-recursive solution, we need to use stack.
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //at here, if I didn't specify as "Stack<TreeNode>",
        //then, I have to cast when pop() from stack
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        //iterative solution
        while(root != null || st.empty() == false){
            if(root != null){
                result.add(root.val);
                st.push(root);
                root = root.left;
            }
            else{
                root = st.pop();
                root = root.right;
            }
        }
        
        return result;
    }
}