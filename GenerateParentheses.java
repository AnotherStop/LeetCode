/*
 * Key point: deepth first strategy
 *   I can't conceive this solution by myself. Refering from others.
 * To-Do: making sure the java parameter passing mechanism
 */

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        StringBuffer sb = new StringBuffer();
        sb.append("");
        return helper(n, 0, 0, sb);
    }
    
    //parameter: total pairs n, left parenthese left, right parenthese right, temp buffer temp
    public ArrayList<String> helper(int n, int left, int right, StringBuffer sb){
        ArrayList<String> result = new ArrayList<String>();
        
        if(left > n || right > n)
            return result;
        
        //Work has been done, adding current StringBuffer to result    
        if(left == n && right == n){
            result.add(sb.toString());
            return result;
        }
        
        //left parenthese "(" is not enough
        if(left < n){
            
            //adding a "(" to the end of string buffer sb
            StringBuffer temp = new StringBuffer(sb);
            temp.append("(");
            
            //call helper() recursively
            result.addAll( helper(n, left+1, right, temp) );
        }
        
        //only if right parenthese ")" is less than right parenthese ")"
        //we can add a ")"; otherwise, we shouldn't add ")".
        if(right < left){
            
            //adding a ")" to the end of string buffer sb
            StringBuffer temp = new StringBuffer(sb);
            temp.append(")");
            
            //call helper() recursively
            result.addAll( helper(n, left, right+1, temp) );
        }
        
        return result;
    }
}