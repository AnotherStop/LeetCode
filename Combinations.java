/*
 *Key point: dfs, like Subsets, Permutation, Combination Sum
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        //n should be greater than or equal to k
        if(n < k){
            k = n;
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(n <= 0)
            return result;
        
        //start point is 1 rather than 0 because it isn't an array, count is 0 when begin    
        dfsWorker(n, k, 1, 0, result, temp);    
            
        return result;
    }
    
    //start is the start point while count is how many elements we have
    public void dfsWorker(int n, int k, int start, int count, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
        if(count == k){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = start;i<n+1;i++){
            temp.add(i);
            
            //take care of i+1, I made typo as start+1 several times
            dfsWorker(n,k,i+1,count+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}