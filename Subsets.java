/*
 *Key point: dfs, a basic question of dfs, good example to practice dfs
 * eg. S = {1,2,3}
 * []
 * [1] <=> [1,2] <=> [1,2,3]
 * [2] <=> [2,3]
 * [3]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if(S == null)
            return null;
            
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //empty set is the subset of any set
        result.add(new ArrayList<Integer>());
        
        //sort array to statisfy the requirement of non-descending order
        Arrays.sort(S);
        
        dfsWorker(S, 0, result, new ArrayList<Integer>());
        
        return result;
    }
    
    public void dfsWorker(int[] S, int position, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
        for(int i = position;i<S.length;i++){
            temp.add(S[i]);
            
            //call dfsWorker() recursively
            dfsWorker(S, i+1, result, temp);
            result.add((ArrayList<Integer>) temp.clone());
            
            //remove current element from temp before next interation
            temp.remove(Integer.valueOf(S[i]));
        }
        
    }
}