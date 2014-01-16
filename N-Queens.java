/*
 * Key point: dfs, 
 *   using an array location[] to store the location of column of the Queen in each row
 *   this idea can immediately avoid the potential collisions among rows
 */

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        
        if(n <= 0)
            return result;
        
        //store each solution using an array location[]    
        int[] location = new int[n];
        
        dfsWorker(result, location, n, 0);
        
        return result;
    }
    
    public void dfsWorker(ArrayList<String[]> result, int[] location, int n, int currentRow){
        
        //find a valid solution, add it to result
        if(currentRow == n)
            addSolution(result, location, n);
        else{    
            //otherwise, find a position in current row and valid whether it's valid so far
            for(int i = 0;i<n;i++){
                location[currentRow] = i;
                
                //if everything is OK, go deeper
                if(isValid(location, currentRow))
                    dfsWorker(result, location, n , currentRow + 1);
            }
        }
    }
    
    //checking whether it's valid so far
    //there has no collision among rows which is guaranteed by location[]
    //only columns and diagonal direction may have collision
    public boolean isValid(int[] location, int currentRow){
        for(int i = 0;i<currentRow;i++){
            
            //collision among columns
            if(location[i] == location[currentRow])
                return false;
                
            int rowDistance = currentRow - i;
            int columnDistance = location[currentRow] - location[i];
            columnDistance = columnDistance > 0 ? columnDistance : -columnDistance;
            
            //collision in diagonal line
            if(rowDistance == columnDistance)
                return false;
        }
        
        //otherwise, it's valid so far
        return true;
    }
    
    //add a solution to result
    public void addSolution(ArrayList<String[]> result, int[] location, int n){
        StringBuffer sb = new StringBuffer();
        for(int j = 0;j<n;j++)
                sb.append('.');        
        String[] row = new String[n];
        
        for(int i = 0;i < n;i++){
            sb.setCharAt(location[i],'Q');
            row[i] = sb.toString();
            sb.setCharAt(location[i], '.');
        }
        
        result.add(row);
    }
}