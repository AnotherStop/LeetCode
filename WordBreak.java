/*
 * Key point: good practice for dp, first try to use recursive solution
 *    but time limit exceed
 */

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0 || dict == null)
            return true;
            
        int length = s.length();

        //dp[i] is true when the substring from i to the end can be partitioned
        boolean[] dp = new boolean[length+1];
        for(boolean b : dp)
            b = false;
            
        //empty string can be partitioned for sure    
        dp[length] = true;    
        
        //bottom up dp, start from the end
        for(int i = length - 1;i>=0;i--){
            for(int j = i;j < length;j++){
                String sub = s.substring(i,j+1);
                if(dict.contains(sub) == true && dp[j+1] == true){
                    dp[i]= true;
                    break;  //break, just jump out current level of loop
                }
            }
        }
        
        return dp[0];
    }
}


/*********recursive solution***********/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(dict.contains(s) == true) 
            return true;
            
        int length = s.length();
        for(int i = 1;i < length;i++){
            
            String firstPart = s.substring(0,i);
            if(dict.contains(firstPart) == true){
                
                String remainPart = s.substring(i,length);
                
                boolean result = wordBreak(remainPart, dict);
                if(result == true){
                    return true;
                }
            }
        }
        
        return false;
    }
}