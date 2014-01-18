/*
 * Key point: using "e" as delimiter to split string 
 *   and then valid base and power parts separtely.
 *
 * Lession: s.trim() return a new string which is trimmed
 *  ? may be String.split() has a bug, refer to line 17
 */

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        //s is empty or only has spaces or end with 'e' is false
        if(s.length() == 0 || (s.length() > 0 && s.charAt(s.length()-1) == 'e'))
            return false;
            
        //using "e" as delimiter
        //? may be there is a bug
        //when s is "e9" s.split() will return two Strings
        //the first one is an empty String, the second is "9"
        //have to eliminate empty string at line 44    
        String[] splitted = s.split("e");
        if(splitted.length > 2)
            return false;
            
        boolean baseResult = isValid(splitted[0], false);
        boolean powResult = true;
        
        if(splitted.length == 2)
            powResult = isValid(splitted[1], true);
            
        return baseResult && powResult;
    }
    
    //boolean argument hasPoint indicate whether has point
    public boolean isValid(String s, boolean hasPoint){
        if(s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
            s = s.substring(1);
        
        char[] charArray = s.toCharArray();
        
        //checking charArray.length == 0 because String.split() methed
        //will return an empty string when delimiter appear at the very
        //first of String, not sure if it's a bug of String.split()
        //refer to comment at line 14
        if (charArray.length == 0 || s.equals("."))
            return false;
        
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '.') {
                if (hasPoint)
                    return false;   //meet point again,return false
                hasPoint = true;    //first meet point, set hasPoint true
            } 
            else if (!('0' <= charArray[i] && charArray[i] <= '9')) {
                return false;
            }
        }

        return true;
    }
}