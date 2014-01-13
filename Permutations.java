/*
 *Key point: dfs, 
 *  it's similar to question Subsets; however, we need all elements rather than subsets
 *  so, we have to scan from beginning of array and need a boolean array to store which element has been visited
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num == null)
            return null;
            
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        //array to store visitting status
        boolean[] visited = new boolean[num.length];
        for(boolean b : visited)
            b = false;
        
        dfsWorker(num, visited, result, temp);
        
        return result;
    }
    
    public void dfsWorker(int[] num, boolean[] visited, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
        
        //temp will be add to result only if its size is equal to num.length
        if(temp.size() == num.length){
            result.add((ArrayList<Integer>) temp.clone());
            return;
        }
        
        //scan from beginning of array, 
        for(int i = 0;i<num.length;i++){
            
            //if it hasn't been added to the current recursive path, add it and go deeper, then remove it and return
            if(visited[i] == false){
                temp.add(num[i]);
                //mark it as visited
                visited[i] = true;
                //work recursively
                dfsWorker(num, visited, result, temp);
                temp.remove(Integer.valueOf(num[i]));
                //mark it as unvisited before move to next iteration
                visited[i] = false;
            }
        }
        
    }
}