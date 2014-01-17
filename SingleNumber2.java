/*
 * Key point: bit magic 
 *   sum each bit of the n number and module the sum of each bit by 3
 *   the result (o or 1) is the one appears in the corresponding bit of result
 */

public class Solution {
    public int singleNumber(int[] A) {
        int total = A.length;
        
        int result = 0;

        //suppose the int is 32 bit
        for(int i = 0;i<32;i++){
            int bit = 0;
            
            //sum the ith bit of all element
            for(int j = 0;j<total;j++){
                bit += (A[j] >> i) & 1;
            }
            
            //set the ith bit of final result
            result |= ((bit % 3) << i);
        }
        
        return result;
    }
}