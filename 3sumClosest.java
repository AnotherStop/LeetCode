/*
 *Key point: we need to return the sum of the three integers, rather than the closest distance
 */
import java.util.Arrays;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        //sort array firstly
        Arrays.sort(num);
        
        int closestDistance = -1;
        int closestSum = 0;
        int currentDistance;
        
        int i = 0;
        int len = num.length;
        int j,k;
        int sumthree;
        while(i < len - 2){
            j = i+1;
            k = len - 1;
            while(j < k){
                sumthree = num[i]+num[j]+num[k];
                currentDistance = (sumthree - target > 0) ? (sumthree - target) : (target - sumthree);
                
                //if distance is 0, it must be the closest, return immediately
                if(currentDistance == 0)
                    return sumthree;
                    
                if(closestDistance < 0){
                    closestDistance = currentDistance;
                    closestSum = sumthree;
                }
                else if(currentDistance < closestDistance){
                    closestDistance = currentDistance;
                    closestSum = sumthree;
                }

                //skip duplicate elements    
                if(sumthree - target < 0)
                    while(j < len - 1 && num[j] == num[++j]);
                else
                    while(k>j && num[k]==num[--k]);
            }
            
            //skip duplicate elements
            while(i < len - 2 && num[i]==num[++i]);
        }
        
        return closestSum;
    }
}