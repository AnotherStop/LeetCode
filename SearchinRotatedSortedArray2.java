/*
 * Key point: much like the Search in Rotated Sorted Array I
 *     Difference:
 *     because there may have duplicate elements, when A[start] == A[mid],
 *     when can't make sure that the left half is sorted. (e.g. A[] = {1,3,1,1,1})
 *     In this case, we have to search on both halfs.
 */
public class Solution {
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0 || (A.length == 1 && A[0] != target))
            return false;
            
        return binarySearch(A, target, 0, A.length-1);
    }
    
    public boolean binarySearch(int[] A, int target, int start, int end){
        int mid = (start + end)/2;
        if(A[mid] == target)
            return true;
            
        if(start >= end)
            return false;
            
        boolean result = false;

        //left half is sorted
        if(A[start] < A[mid]){
            //target in left half
            if(target >= A[start] && target < A[mid])
                result = binarySearch(A, target, start, mid - 1);
            else//target in right half
                result = binarySearch(A, target, mid+1, end);
        }
        //in this condition, we can't tell which half is sorted,
        //so, we have to try against both sides
        else if(A[start] == A[mid]){
            //first, try on the left half
            result = binarySearch(A, target, start, mid - 1);
            if(result == true)
                return result;
            
            //if necessary, try on right half    
            result = binarySearch(A, target, mid+1, end);
        }
        else{//right half is sorted
            //target in right half
            if(target > A[mid] && target <= A[end])
                result = binarySearch(A, target, mid+1, end);
            else//target in right half
                result = binarySearch(A, target, start, mid - 1);
        }
        
        return result;        
    }
}