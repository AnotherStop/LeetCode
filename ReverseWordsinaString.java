/*
 * Key point: using regular expression to split string
 *    The string.split() method will match any valid delimiter
 *    regardless of its position, which means even if the delimiter
 *    appears at the begining of string. In this condition, it will
 *    suppose there is an empty string before the delimter.
 */
public class Solution {
    public String reverseWords(String s) {
        if(s == null)
            return s;
        
        //trim leading and trailing spaces    
        String trimmed = s.trim();
        
        //split string using space(s) as delimiter
        String[] splitted = trimmed.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for(int i = splitted.length - 1;i>=0;i--){
            sb.append(splitted[i]);
            if(i != 0)
                sb.append(" ");
        }
        
        return sb.toString();
    }
}