/*
 *Key point: It's a well known characteristic of XOR;
 * that's any integer xor with 0 equals to itself and 
 * any integer xor with itself twice equals to 0
 */

public class Solution {
    public int singleNumber(int[] A) {
        if(A.length == 1)
            return A[0];
            
        int result = 0;
        int i;
        
        for(i = 0;i < A.length; i++){
            result = result ^ A[i];
        }
        
        return result;
    }
}