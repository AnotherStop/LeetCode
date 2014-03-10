/*
 * Key point: dfs, figure out possible BST set for each node
 *            combine left and right set at parent node
 *   
 *   even if a child has no BST, adding a null to its result set,
 *   so, that set won't be empty. Then, it's easy to be merged at its parent
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return dfsWorker(1,n);
    }
    
    public ArrayList<TreeNode> dfsWorker(int start, int end){

        //result set for current node
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        
        //adding null to result set to avoid empty set
        if(start > end){
            result.add(null);
            return result;
        }
        

        for(int i = start;i<=end;i++){

            //result set for left and right child
            ArrayList<TreeNode> left = dfsWorker(start, i -1);
            ArrayList<TreeNode> right = dfsWorker(i+1, end);
            
            //combine left and right child set at their parent
            for(int j = 0;j<left.size();j++){
                for(int k = 0;k<right.size();k++){
                    TreeNode root = new TreeNode(i);
                    
                    root.left = left.get(j);
                    root.right = right.get(k);
                    
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}