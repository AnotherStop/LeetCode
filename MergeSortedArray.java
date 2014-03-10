/*
 * Key point: think out-of-box, two pointers
 *      A[] is large enough, this means the rear part of A[] is empty
 *      we can wrtie to that part freely. So, we figure out the merged array
 *      in a reverse order that is work from last elements to first one.
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {

        //define three pointers for A[], B[] and current sorted index
        int i = m-1, j = n-1, k = m+n-1;
        
        while(i>=0 && j>=0 && k>=0){
            if(A[i] < B[j]){
                A[k] = B[j];
                j--;
            }
            else{
                A[k] = A[i];
                i--;
            }
            
            k--;
        }
        
        while(i>=0){
            A[k] = A[i];
            i--;
            k--;
        }
        
        while(j>=0){
            A[k] = B[j];//notice, here is B[j]
            j--;
            k--;
        }
    }
}