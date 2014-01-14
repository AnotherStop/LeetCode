/*
 * Key point: dfs, the idea is like Subsets, Permutation
 * 
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null)
            return null;
            
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(target <= 0)
            return result;
        
        Arrays.sort(candidates);
        //currentSum and position are all 0
        dfsWorker(candidates, target, result, temp, 0, 0);
        
        return result;
    }
    
    public void dfsWorker(int[] candidates, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int currentSum, int position){
        
        //currentSum reachs target, add the current sequence to result
        if(currentSum == target){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        if(currentSum > target)
            return;
        
        for(int i = position;i<candidates.length;i++){
            
            //only no greater than target element will be considered
            if(candidates[i] <= target){
                temp.add(candidates[i]);
                
                //since same number can be used more than once, the position is still "i" in arguments
                dfsWorker(candidates, target, result, temp, candidates[i]+currentSum, i);
                
                temp.remove(temp.size()-1);
                
                //skip duplicate elements
                while(i < candidates.length - 1 && candidates[i] == candidates[i+1])
                    i++;
            }
        }
        
    }
}