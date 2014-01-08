/*
 *Much like 3sum
 *Key point: re-assign the value of j at the beginning of each i's iteration, so does k and l
 */
import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        int i = 0;
        int j = i+1;
        int k,l;
        while(i < len-3){
            j = i + 1;
            while(j < len-2 ){
                l = len - 1;
                k = j+1;
                while(k<l){
                    int sumfour = num[i]+num[j]+num[k]+num[l];
                
                    if(sumfour == target){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);
                        if(!result.contains(temp))
                            result.add(temp);
                        //skip duplicate elements
                        while(k < len - 1 && num[k] == num[++k]);
                        while(l > k && num[l] == num[--l]);
                    }
                    else if(sumfour < target){
                        //skip duplicate elements
                        while(k < len - 1 && num[k] == num[++k]);
                    }
                    else{
                        //skip duplicate elements
                        while(l > k && num[l] == num[--l]);
                    }
                }   
                //skip duplicate elements
                while(j < len -2 && num[j] == num[++j]);
            }
            //skip duplicate elements
            while(i < len - 3 && i < j && num[i] == num[++i]);
        }
        return result;
    }
}