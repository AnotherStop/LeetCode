/*
 *Key point: we need to return the indices in original array, so it's
 *  necessary to backup the original array before we sort it.
 *
 *Key point: when we are looking for the indices based on checking values,
 *  if the values are same, make sure the second one doesn't overwrite the first
 *  That's why I initialized the result array with {-1,-1} to check if we have got
 *  indices. Refer to line 48, without checking result[0] == -1, we can't pass
 *  test case: [0,1,2,0] target = 0 
 */
import java.util.Arrays;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        //make a copy of numbers array
        int[] copynumbers = new int[numbers.length];
        for(int k = 0;k<numbers.length;k++)
            copynumbers[k] = numbers[k];
        
        //sort the array firstly
        Arrays.sort(numbers);
        
        int[] temp = new int[2];
        int[] result = {-1,-1}; //use -1 to indicate that it haven't been initialized
        int i = 0;
        int j = numbers.length - 1;
        int sumtwo;
        while(i < j){
            sumtwo = numbers[i]+numbers[j];
            if(sumtwo == target){
                //save the values into temp array
                temp[0] = numbers[i];
                temp[1] = numbers[j];
                break;
            }
            else if(sumtwo > target){
                //skip duplicate elements
                while(j>i && numbers[j] == numbers[--j]);
            }
            else{
                //skip duplicate elements
                while(i<j && numbers[i] == numbers[++i]);
            }
        }
        
        for(i = 0;i<copynumbers.length;i++){
            //since return answers are not zero-based, add 1 to them
            //check whether result has been assigned
            if(result[0] == -1 && copynumbers[i] == temp[0])
                result[0] = i+1;
            else if(result[1] == -1 && copynumbers[i] == temp[1] )
                result[1] = i+1;
        }
        
        Arrays.sort(result);
        return result;
    }
}