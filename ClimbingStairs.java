/*
 * Key point: dp, d(i) = d(i-1) + d(i-2), i>=2, d(1) = 1,d(2) = 2
 *     recursive soltion will exceed time limit
 */
public class Solution {
    public int climbStairs(int n) {
        if(n <= 0)
            return 0;
        else if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else{
            int oneStepLower = 1;   //d(1) = 1
            int twoStepsLower = 2;  //d(2) = 2
            int current = 0;
            
            while(n - 2 > 0){
                current = oneStepLower + twoStepsLower;
                oneStepLower = twoStepsLower;
                twoStepsLower = current;
                n--;
            }
            
            return current;
        }
    }
}