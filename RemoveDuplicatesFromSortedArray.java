/*
 *This problem is described in a somewhat ambiguous way.
 *
 *According to the test case, this problem asks us to move
 *  all distinct elements (suppose n totally) to the first n entries
 *  of the original array and return the value n.
 *I guess the verdict will truncate and test the first n entries from original array A[].
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 2)
            return A.length;
        
        //set length to 1
        int len = 1;
        int i= 0;
        int j = i;
        while(i < A.length-1){
            //skip duplicate elements
            while(j < A.length-1 && A[i] == A[++j]);
            
            //reach the end of array
            if(j == A.length -1){
                //the last element isn't distince
                if(A[i] == A[j]){
                    i++;
                    break;       
                }
                else{// the last element is distinct
                    A[i+1] = A[j];
                    i++;
                    len++;
                }
            }
            else{// doesn't reach the end
                A[i+1] = A[j];
                i++;
                len++;
            }
        }
        
        return len;
    }
}