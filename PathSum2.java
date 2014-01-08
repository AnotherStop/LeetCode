/*
 *Key point: depth first search to calculate the sum of each path,
 * if the path sum equals to target 'sum', create an element 
 * in ArrayList<ArrayList<Integer>> 'result' to store the value of node of this path
 * and create an ArrayList<Integer> 'index' to store the index of 
 * this element in ArrayList<ArrayList<Integer>>.
 * 
 * if a non-leaf node found subtree return an empty ArrayList<Integer> 'index', it's not
 * in a valid path; otherwise, add its value to valid path
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
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(root == null)
            return result;
        
        calSum(root,sum,0,result);
        
        return result;
    }
    
    //return the index of ArrayList<Integer> in the ArrayList<ArrayList<Integer>>
    public ArrayList<Integer> calSum(TreeNode root, int sum, int currentSum, ArrayList<ArrayList<Integer>> result){

        currentSum = currentSum + root.val;
        
        //reach a leaf
        if(root.left == null && root.right == null){
            
            ArrayList<Integer> index = new ArrayList<Integer>();
            index.clear();
            //if this path sum equals to 'sum', create a new ArrayList<Integer> and add it to result
            if(currentSum == sum){
                ArrayList<Integer> path = new ArrayList<Integer>();
                path.add(0, root.val);
                result.add(path);   //add path to result
                
                //if using indexOf() rather than lastIndexOf(), path of same value can't be distinguished
                int i = result.lastIndexOf(path);   
                index.add(i);   //record the index of this path in ArrayList<ArrayList<Integer>>
            }
            return index;
        }
        
        //merge the index record ArrayList of two subtree together
        ArrayList<Integer> mergedIndex = new ArrayList<Integer>();
        ArrayList<Integer> leftIndex = null;
        ArrayList<Integer> rightIndex = null;
        if(root.left != null){
            leftIndex = calSum(root.left, sum, currentSum, result);
            mergedIndex.addAll(leftIndex);
        }
        if(root.right != null){
            rightIndex = calSum(root.right, sum, currentSum, result);
            mergedIndex.addAll(rightIndex);
        }
            
        //add the current value to valid path
        if(!mergedIndex.isEmpty()){
            Iterator iter = mergedIndex.iterator();
            while(iter.hasNext()){
                Integer i = (Integer) iter.next();
                result.get(i).add(0,root.val);
            }   
        }
        return mergedIndex;
            
    }
}