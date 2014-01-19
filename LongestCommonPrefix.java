/*
 * key point: sort String[], then test each character of 
 *  the shortest String against all Strings
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
            
        Arrays.sort(strs);
        
        int longestLength = strs[0].length();
        String result = null;
        
        char current = '\0';
        for(int i  = 0;i<longestLength;i++){
            current = strs[0].charAt(i);
            for(int j = 0;j<strs.length;j++){
                if(current != strs[j].charAt(i)){
                    result = strs[0].substring(0,i);
                    return result;
                }
                    
            }
        }
        
        return strs[0];
    }
}