/*
 *Key point: because we merely plus one, there will be
 * no carry bit unless all digits are 9
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        
        if(length == 0)
            return null;
        
        //checking whether all digits are 9
        int i = 0;
        int allNine = 1;
        for(i = length - 1; i >= 0;i--){
            if(digits[i] != 9)
                allNine = 0;
        }
        
        //if all digits are 9, create a new array to return
        if(allNine == 1){
            int[] result = new int[length+1];
            result[0] = 1;
            for(i = 1;i<result.length;i++)
                result[i] = 0;
            return result;
        }
        
        //if all digits are not 9, calculate it
        for(i = digits.length-1;i>=0;i--){
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }
            else{
                digits[i] = 0;
    
            }
        }
        
        return digits;
    }
}