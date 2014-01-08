/*
 *Key point: I made many attempts to write the non-recursive solution,
 * after we find the lower bound, we can use it as the left boundry
 * and start to find the upper bound
 */

public class Solution {
    public int[] searchRange(int[] A, int target) {
        
        int[] result = {-1,-1};
        int begin = 0;
        int end = A.length-1;
        int mid;

        // Search for lower bound
        while (begin < end) {
            mid = (begin + end) / 2;
            if (A[mid] < target)
                begin = mid + 1;
            else
                end = mid;  //because now we're looking for lower bound
        }

        // If the target is not found, return (-1, -1)
        if (A[begin] != target)
            return result;
        else
            result[0] = begin;

        // Search for upper bound
        //reset the end value and remain the begin value as it is
        end = A.length-1;   
        while (begin < end) {
            mid = (begin + end) / 2;
            if (A[mid] > target)
                end = mid;
            else
                begin = mid + 1;    //because we're looking for upper bound
        }
        
        //the last loop is terminated when begin == end
        //but the value of end has two possibilities
        if(A[end] == target)
            result[1] = end;
        else
            result[1] = end - 1;

        return result;
    }
    
}