/*
 * Key point: dp
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
            
        for(int i = 0;i < x;i++){
            for(int j = 0;j < y;j++){
                
                if(i == 0){ //first row
                    if(j == 0)
                        continue;
                    else
                        grid[i][j] += grid[i][j-1]; 
                }
                else if(j == 0){    //first column
                    if(i == 0)
                        continue;
                    else
                        grid[i][j] += grid[i-1][j]; 
                }
                else{
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        
        return grid[x-1][y-1];
    }
}