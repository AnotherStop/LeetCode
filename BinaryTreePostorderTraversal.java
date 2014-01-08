/*
 *Key point: postorder traversal is the more complicated than preorder and inorder traversal
 *   We need an extra reference to indicate which node is the last visited one. A node is 
 *   visited only if it has no right child or its right child has been visited
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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode lastVisited = null;
        TreeNode peekNode = null;
        
        while(root != null || st.empty() == false){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
                peekNode = st.peek();   //peek() return the top element of stack without pop it 
                
                //move to right only if right child exists and never visited
                if(peekNode.right != null && lastVisited != peekNode.right){
                    root = peekNode.right;
                }
                else{  //otherwise, visiting this node and pop it out
                    result.add(peekNode.val);
                    st.pop();
                    lastVisited = peekNode;
                }
            }
        }
        
        return result;
    }
}