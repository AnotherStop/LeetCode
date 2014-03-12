/*
 * Key point: in-place counting sort of range 1 to A.length, when A.length > 0
 *   the ideal result should be [1,2,3...], the first occurance of A[i] != i+1
 *   indicate the missing positive is i+1
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;

        int i = 0;
        while(i<n){
            //leave negative or positive greater than n as it is
            //if current is alread suitable located, skip
            //if the current is not suitable, but the target spot is suitable,skip
            //otherwise, swap them
            if(A[i] > 0 && A[i] <= n && A[i]-1 != i && A[A[i]-1] != A[i]){
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
            }
            //after swap a,b, a occupies b's spot, a is suitable; 
            //but b takes up a's spot may not be suitable, 
            //so don't increase i unless no work to be done for current spot
            else
                i++;  
        }
        
        //check the first missing positive
        for(i = 0;i<n;i++){
            if(A[i] != i+1)
                return i+1;
        }
        
        return n+1;
    }
}