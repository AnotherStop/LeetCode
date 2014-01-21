/*
 * Key point: use switch and make sure how the roman
 *  numeral works
 */

public class Solution {
    public int romanToInt(String s) {
        
        if(s.length() == 0)
            return 0;
            
        int result = 0;
        int current = 0;    //current char's value
        int last = 0;   //last char's value

        for(int i = 0;i < s.length();i++){
            switch(s.charAt(i)){
                case 'M' : current = 1000; break;
                case 'D' : current = 500; break;
                case 'C' : current = 100; break;
                case 'L' : current = 50; break;
                case 'X' : current = 10; break;
                case 'V' : current = 5; break;
                case 'I' : current = 1; break;
            }
            
            result += current;
            
            //test the condition of substractive notation
            //such as IX, XL, CD
            //first char won't need to be tested
            if(i == 0 || current <= last){
                last = current;
            }
            else{
                result -= last;
                result -= last;
            }
        }
        
        return result;
    }
}