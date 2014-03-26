/*
 * Key point: dp, create a size n array dp1[] to store minimum sum
 *     for each node of last line, then based on dp1[] calculate dp2[] that for
 *     current line. After finishing current line, swap dp2[] and dp1[] and move
 *     to next line.
 */
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0)
            return 0;

        int[] dp1 = new int[n]; //last line
        int[] dp2 = new int[n]; //current line
        
        dp1[0] = triangle.get(0).get(0);
        
        for(int line = 1;line < n;line++){
            int rowLength = triangle.get(line).size();
            for(int index = 0;index < rowLength;index++){
                int current = triangle.get(line).get(index);
                
                if(index == 0){
                    dp2[index] = dp1[0] + current;
                }
                else if(index == rowLength-1){
                    dp2[index] = dp1[index - 1] + current;
                }
                else{
                    dp2[index] = Math.min(dp1[index-1], dp1[index]) + current;
                }
            }
            
            int[] temp = dp1;
            dp1 = dp2;
            dp2 = temp;
        }
        
        int minSum = Integer.MAX_VALUE;
        for(int i : dp1){
            if(i < minSum)
                minSum = i;
        }
        
        return minSum;
        
    }
}