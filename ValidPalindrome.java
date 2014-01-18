/*
 * Key point: two pointers, one from begin, the other from end
 */

public class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length();
        
        if(length == 0)
            return true;
            
        int begin = 0;
        int end = length - 1;
        
        while(begin < end){
            char beginChar = s.charAt(begin);
            
            //checking whether alphanumeric characters
            if(! ((beginChar >= 65 && beginChar <=90) || (beginChar >= 97 && beginChar <= 122) || (beginChar >= 48 && beginChar <=57)) ){
                begin++;
                continue;
            }
            else{
                //convert capital case to lower case
                if(beginChar >= 65 && beginChar <=90)
                    beginChar = (char) (beginChar - 'A' + 'a');
            }
            
            char endChar = s.charAt(end);

            //checking whether alphanumeric characters
            if(! ((endChar >= 65 && endChar <=90) || (endChar >= 97 && endChar <= 122) || (endChar >= 48 && endChar <=57)) ){
                end--;
                continue;
            }
            else{
                //convert capital case to lower case
                if(endChar >= 65 && endChar <=90)
                    endChar = (char) (endChar - 'A' + 'a');
            }
            
            if(beginChar == endChar){
                begin++;
                end--;
            }
            else
                return false;
                
        }
        
        return true;
    }
}