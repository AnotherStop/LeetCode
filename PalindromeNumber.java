/*
 * Key point: two pointer so that don't use extra space
 *
 * Note: My code isn't language independent.
 *  Refer to: http://leetcode.com/2012/01/palindrome-number.html
 *  That's a elegant solution
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        int length = (int) (Math.log10(x));
        int high = length;
        int low = 0;
        
        int leftDigit = 0;
        int rightDigit = 0;
        while(high > low){
            leftDigit = (int) (x / Math.pow(10, high)) % 10;
            
            rightDigit = (int) (x / Math.pow(10, low)) % 10;
            
            if(leftDigit != rightDigit)
                return false;
                
            high--;
            low++;
        }
        
        return true;
    }
}