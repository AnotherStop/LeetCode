/*
 * Key point: add a "0" to the beginning of a and b
 *   so that there will be no carry to increase length
 *   then, add "0" to the shorter string until a and b
 *   are of same length
 *   finally check whether the first char of result is "0"
 *   if so, trim it before return
 */

public class Solution {
    public String addBinary(String a, String b) {
        if(a == null && b == null)
            return null;
            
        if(a != null && (b == null || b.length() == 0))
            return a;
            
        if(b != null && (a == null || a.length() == 0))
            return b;
        
        //make string a is the shorter one
        if(a.length() > b.length()){
            String temp = a;
            a = b;
            b = temp;
        }

        //add 0 to the beginning of a and b
        a = "0"+a;
        b = "0"+b;

        StringBuffer sb = new StringBuffer();
        for(int i = b.length() - a.length(); i > 0;i--){
            sb.insert(0,'0');
        }

        //using "0" to make a and b of same length
        a = sb.toString()+a;
        
        int bit = 0;
        int carry = 0;
        int tempSum = 0;
        sb.setLength(0);    //clear StringBuffer sb
        
        for(int i = 0;i < a.length();i++){
            tempSum = carry + (int) (a.charAt(a.length() - 1 - i) - '0') + (int) (b.charAt(b.length() - 1 - i) - '0');
            bit = tempSum % 2;
            carry = tempSum / 2;
            sb.insert(0, (char) ('0' + bit));
        }
        
        //if the first char of result isn't 1, remove it
        if(sb.charAt(0) == '0'){
                return sb.substring(1);
        }
        else
            return sb.toString();     
        
    }
}