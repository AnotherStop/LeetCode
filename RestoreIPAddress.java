/*
 *  Key point: dfs, but it's not like Subsets, Permutation, Combination which 
 *     scan original Array or List. This question continuously truncates orginal String
 *     to decrease the size of question
 *
 *     Reference: http://blog.csdn.net/u011095253/article/details/9158449
 */

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        
        //IP address has at least 4 digits and at most 12 digits
        if(s == null || s.length() < 4 || s.length() > 12)
            return result;
            
        String temp = "";
        
        //we start to work on the part 1 of IP address
        dfsWorker(s, result, temp, 1);
        
        return result;
    }
    
    //argument part is to indicate which part of IP address we are working on
    public void dfsWorker(String s, ArrayList<String> result, String temp, int part){
        
        //when we're working on part 4 of IP address, the whole s is the candidate of part 4
        if(part == 4 && isValid(s) == true){
            result.add(temp+s);
            return;
        }
        
        //each part of IP address has 1 to 3 digits
        //Notice: the String s may be shorter than i during recursive work
        //so it's important to make sure i < s.length()
        for(int i = 1;i <= 3 && i < s.length();i++){
            //truncate the first i characters (0 to i-1) as the candidate for a part
            String substr = s.substring(0,i);
            
            //if the truncated part is valid, recursively work on next part of IP address
            if(isValid(substr) == true){
                dfsWorker(s.substring(i), result, temp+substr+".", part+1);
            }
        }
    }
    
    //checking whether truncated part of String is a valid part
    public boolean isValid(String s){
        
        //if it starts with 0, it must be "0", IP address doesn't allow 0X or 00X
        if(s.charAt(0) == '0')
            return s.equals("0");
            
        //parse String to corresponding integer    
        int number = Integer.parseInt(s);
        
        return number >= 0 && number <=255;
    }
}