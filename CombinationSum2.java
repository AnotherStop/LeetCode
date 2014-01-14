/*
 * Key point: dfs, much like Combination Sum, the only difference is at Line 37
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if(num == null)
            return null;
            
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(target <= 0)
            return result;
        
        Arrays.sort(num);
        //currentSum and position are all 0
        dfsWorker(num, target, result, temp, 0, 0);
        
        return result;        
    }
    
    public void dfsWorker(int[] candidates, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int currentSum, int position){
        if(currentSum == target){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        if(currentSum > target)
            return;
        
        for(int i = position;i<candidates.length;i++){
            if(candidates[i] <= target){
                temp.add(candidates[i]);
                
                //since each number can be used at most once, so pass "i+1" as position,
                //otherwise, if passing "i", the same element will be used more than once
                dfsWorker(candidates, target, result, temp, candidates[i]+currentSum, i+1);
                temp.remove(temp.size()-1);
                
                //skip duplicate elements
                while(i < candidates.length - 1 && candidates[i] == candidates[i+1])
                    i++;
                
            }
        }
        
    }
    
}