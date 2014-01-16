/*
 * Key point: using stack
 *
 *   I made attempts on using dfs. not a good idea
 */

public class Solution {
    public boolean isValid(String s) {
        if(s == null || s == "")
            return true;
            
        if(s.length() % 2 == 1)
            return false;
        
        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0;i<s.length();i++){
            char current = s.charAt(i);
            
            //left parts are always pushed to stack
            if(current == '(' || current == '[' || current == '{')
                st.push(current);
                
            //as soon as meeting a right part, pop() an element
            //if didn't match, return false    
            if(current == ')'){
                if(st.empty() || st.pop() != '(')
                    return false;
            }
            
            if(current == ']'){
                if(st.empty() || st.pop() != '[')
                    return false;
            }
            
            if(current == '}'){
                if(st.empty() || st.pop() != '{')
                    return false;
            }
            
        }
        
        //if the stack isn't empty after scanning the whole string
        if(st.empty() == false)
            return false;
            
        return true;
        
    }

}