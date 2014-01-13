/*
 *Key point: dfs, much like Subsets question
 *   the only difference is that skip duplicate elements before next iteration
 *   which is to avoid duplicate subsets
 *
 *   I was going to use HashMap to eliminate duplicate subsets, but analysizing how
 *   duplicate subsets are generated can conceive a easier solution
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if(num == null)
            return null;
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        result.add(temp);
        
        //sort array to meet non-descending order requirement
        Arrays.sort(num);
        
        dfsWorker(num, 0, result, temp);
        
        return result;
    }
    
    public void dfsWorker(int[] num, int position, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
        for(int i = position;i<num.length;i++){
            temp.add(num[i]);
            
            //call dfsWorker() recursively
            dfsWorker(num, i+1, result, temp);
            
            result.add((ArrayList<Integer>) temp.clone());
            
            //remove current elements before next iteration
            temp.remove(Integer.valueOf(num[i]));
            
            //skip duplicate elements to avoid duplicate subsets
            while(i < num.length - 1 && num[i] == num[i+1])
                i++;
        }
    }
}