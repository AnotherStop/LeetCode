/*
 *Key point: According to the test case, 
 * when the string ends with space, we need to ignore them
 * and continue to find last word rather than treating it as
 * last word doesn't exist.
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = s.length();
        
        if(len == 0)
            return 0;
        
        //ignore the spaces at the end of string
        while (s.charAt(len - 1) == ' '){
            len--;
            //if the string consists of spaces, return 0
            if(len == 0)
                return 0;
        }
        
        int i = len;
        //find the first space before the last word
        while(i > 0){
            if(s.charAt(i - 1) != ' ')
                i--;
            else
                break;
        }
        
        return len - i;
    }
}