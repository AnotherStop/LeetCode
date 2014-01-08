/*
 *Key point: I once conceived a O(m+n) space solution, but the
 * best is a constant space solution. That's using first row and
 * first column as the indicator array to store which column and row
 * should be set to 0. Two boolean variables are needed to store the
 * state of first row and column
 */

public class Solution {
    public void setZeroes(int[][] matrix) {
        
        if(matrix == null)
            return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        int i,j;
        
        //checking first row
        for(j = 0;j<n;j++){
            if(matrix[0][j] == 0)
                firstRowHasZero = true;
        }
        
        //checking first column
        for(i = 0;i<m;i++){
            if(matrix[i][0] == 0)
                firstColHasZero = true;
        }
        
        //checking the rest of matrix and setting corresponding indicator
        for(i = 1;i<m;i++){
            for(j = 1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //setting to 0 according to indicator
        for(i=1;i<m;i++){
            for(j = 1;j<n;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0) 
                    matrix[i][j] = 0;
            }
        }
        
        //handle the first row itself
        if(firstRowHasZero == true){
            for(j = 0;j<n;j++)
                matrix[0][j] = 0;
        }   
        
        //handle the first column itself
        if(firstColHasZero == true){
            for(i = 0;i<m;i++)
                matrix[i][0] = 0;
        }
        
    }
}