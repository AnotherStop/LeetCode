/*
 * Key point: dfs, much like the N-Queens
 */

public class Solution {
    public int totalNQueens(int n) {
        int result = 0;
        
        if(n <= 0)
            return result;
        
        //using location[] to store the column of queen's location in each line    
        int location[] = new int[n];    
        result = dfsWorker(n, location, 0, 0);
        
        return result;
            
    }
    
    //argument count store the number of solutions so far
    public int dfsWorker(int n, int[] location, int count, int currentRow){
        //reaching nth iteration, we find a solution
        if(currentRow == n){
            count++;
        }
        else{
            for(int i = 0;i<n;i++){
                location[currentRow] = i;
                
                if(isValid(location, currentRow) == true){
                    count = dfsWorker(n, location, count, currentRow+1);
                }
            }
        }
        
        return count;
    }
    
    //valid whether the current location has collision with previous queens
    public boolean isValid(int[] location, int currentRow){
        for(int i = 0;i<currentRow;i++){
            if(location[i] == location[currentRow])
                return false;
            
            //checking collision in diagonal line                
            int rowDistance = currentRow - i;
            int columnDistance = location[currentRow] - location[i];
            columnDistance = columnDistance > 0 ? columnDistance : -columnDistance;
            
            if(rowDistance == columnDistance)
                return false;
        }
        
        return true;
    }
}