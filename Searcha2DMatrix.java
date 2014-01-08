/*
 *Key point: binary search to locate the row. It doesn't look like
 * typical binary search because we need to confirm a range 
 * rather than exactly the element. Refer to Line 45
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        //if target is out of scope, return false
        if(target < matrix[0][0] || target > matrix[m-1][n-1])
            return false;
    
        int row = 0;
        //if there's more than one row, binary search which row is the target in
        if(m > 1)
            row = binarySearchRow(matrix, target, 0, m-1);
        
        //after locating the row, binary search within the row
        boolean result = binarySearchIndex(matrix, target, 0, n-1, row);
        
        return result;
        
    }
    
    //binary search among the first elements of each row,
    //to locate which row is the target in
    public int binarySearchRow(int[][] matrix, int target, int begin, int end){
        
        int mid = (begin + end)/2;
        int row = mid;
        
        if(begin < end){
            
            //recursive search on first part
            if(matrix[mid][0] > target){
                row = binarySearchRow(matrix, target, begin, mid-1);
            }    
            else if(matrix[mid][0] < target){
                
                //checking whether target is not in row matrix[mid]
                if(matrix[mid+1][0] <= target){//don't forget the '=' condition
                    row = binarySearchRow(matrix, target, mid+1, end);
                }
                else //target is in row matrix[mid]
                    return mid;
            }
                
        }
        
        return row;
    }
    
    //binary search within a row
    public boolean binarySearchIndex(int[][] matrix, int target, int begin, int end, int row){
        
        int mid = (begin + end)/2;
        boolean result = false;
        
        if(begin <= end){
            if(matrix[row][mid] > target)
                result = binarySearchIndex(matrix, target, begin, mid-1, row);
            else if(matrix[row][mid] < target)
                result = binarySearchIndex(matrix, target, mid+1, end, row);
            else 
                result = true;
        }
        
        return result;
    }
}