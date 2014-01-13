/*
 *Key point: dfs, much like the question Permutation except we need to skip duplicate elements
 *  as the result of avoiding duplicate permutation. Like Subsets and Subsets II
 *
 *  temp.remove(Integer.valueOf(num[i]); will always remove the first instance of object with value num[i]
 *  it works well in question Permutation because all elements are distince but in this question it should 
 *  be replaced by temp.remove(temp.size()-1); because what we really want to do is to remove the last element of temp
 *  though whose value is num[i]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if(num == null)
            return null;
            
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        //array to store visitting status
        boolean[] visited = new boolean[num.length];
        for(boolean b : visited)
            b = false;
        
        //sort num[] first, so that duplicate elements can be skipped in dfsWorker()
        Arrays.sort(num);
        
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
                
                //take care, refer to the comments on top of this file
                temp.remove(temp.size()-1);
                
                //mark it as unvisited before move to next iteration
                visited[i] = false;
                
                //skip duplicate elements, num[] must be sorted
                while(i<num.length-1 && num[i] == num[i+1])
                    i++;
            }
        }
        
    }
    
}