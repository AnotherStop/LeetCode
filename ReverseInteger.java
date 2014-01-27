/*
 * Key point: consider the boundry case, no standard solution
 * My strategy: if overflow, drop the highest digit;
 *              if fist digit is 0, ignore it
 */

public class Solution {
    public int reverse(int x) {
        
        //for numbers have only one digit, directly return
        if(x > -10 && x < 10)
            return x;
        
        int result = 0;    
        int flag = 1; //flag to show if it's negative
        if(x < 0){
            flag = -1;
            x = -x;
        }
        
        //variable to store the first digit
        int firstDigit = -1;
        //the largest int is 2,147,483,647 which is of 10-digits
        for(int count= 1; x != 0 && !(firstDigit > 3 && count >= 10); count++){
            if(firstDigit < 0)
                firstDigit = x % 10;
                
            result = result * 10 + x % 10;
            x = x / 10;
        }
        
        return result*flag;
        
    }
}