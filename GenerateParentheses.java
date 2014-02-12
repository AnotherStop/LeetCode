/*
 * Re-do this question, now dfsWorker() return void
 */
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        if(n <= 0)
            return result;
            
        dfsWorker(n, result, sb, 0, 0);
        return result;
        
    }
    
    public void dfsWorker(int n, ArrayList<String> result, StringBuilder sb, int left, int right){
        
        //"exit" for recursive call
        if(left == right && right == n){
            result.add(sb.toString());
            return;
        }
        
        //invalid combination
        if(left < right || left > n || right > n)
            return;
            
        //condition that add '('    
        if(left < n){    
            sb.append('(');    
            dfsWorker(n, result, sb, left+1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        
        //condition that add ')'
        if(right < left){
            sb.append(')');
            dfsWorker(n, result, sb, left, right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}