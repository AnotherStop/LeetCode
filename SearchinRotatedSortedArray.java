/*
 * Key point: binary search
 *     although this sorted array is rotated, either the left part or the right
 *     part is still sorted. What we need to do is still determining which part
 *     will be searched.
 */
public class Solution {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0 || (A.length == 1 && A[0] != target))
            return -1;
        
        return dfsWorker(A, target, 0, A.length - 1);       
    }
            
    public int dfsWorker(int[] A, int target, int start, int end){
        int mid = (start + end) / 2;
        
        //happy ending
        if(A[mid] == target)
            return mid;
        
        //can't find, return -1    
        if(start >= end)
            return -1;
        
        int result = -1;

        //left half is sorted
        if(A[start] <= A[mid]){
            //target in left half
            if(target >= A[start] && target < A[mid])
                result = dfsWorker(A, target, start, mid - 1);
            else//target in right half
                result = dfsWorker(A, target, mid+1, end);
        } 
        else{//right half is sorted
            //target in right half
            if(target > A[mid] && target <= A[end])
                result = dfsWorker(A, target, mid+1, end);
            else//target in right half
                result = dfsWorker(A, target, start, mid - 1);
        }
        
        return result;    
    }    
}