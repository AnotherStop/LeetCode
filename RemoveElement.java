/*
 *Key point: consider boundry conditions, when A.length < 2 and i == j
 *
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        
        //handle the condition the A.length < 2
        if(A.length == 0)
            return 0;
        else if(A.length == 1){
            if(A[0] == elem)
                return 0;
            else 
                return 1;
        }
        
        int len = 0;
        int i = 0;
        int j = A.length - 1;        
        
        //i==j is necessary to guarantee the correctness
        while(i <= j){
            
            if(A[i] != elem){
                i++;
                len++;
            }
            else{//consider A[i] == elem 
                
                if(A[j] != elem){
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    i++;
                    len++;
                }
                
                j--;
                
            }
        }
        return len;
    }
}