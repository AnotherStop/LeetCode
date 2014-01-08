/*
 *Key point: divide and conquer
 */

public class Solution {
    public double pow(double x, int n) {
        
        if(x == 0)
            return 0;
        
        if(n == 0)
            return 1;
            
        if(n == 1)
            return x;
            
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        
        boolean isOdd = false;
        if(n % 2 == 1)
            isOdd = true;
        
        double result;
        double temp;
        
        //recursive call
        if(n == 2)
            result = x * x;
        else{
            temp = pow(x, n/2); //divide and conquer
            result = temp * temp;
        }
            
        if(isOdd == true)
            result *= x;
            
        return result;
        
    }
}