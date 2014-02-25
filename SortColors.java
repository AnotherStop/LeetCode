/*
 * Key point: Solution1: two pass, like count sort
 *            Solution2: one pass, like quick sort, three pointers
 */
public class Solution {
    public void sortColors(int[] A) {
        if(A.length == 0)
            return;

        //count red, white and blue
        int red = 0, white = 0, blue = 0;    
        for(int i = 0;i<A.length;i++){
            if(A[i] == 0)
                red++;
            else if(A[i] == 1)
                white++;
            else
                blue++;
        }
        
        //set values
        for(int i = 0;i<A.length;i++){
            if(i < red)
                A[i] = 0;
            else if(i < red+white)
                A[i] = 1;
            else
                A[i] = 2;
        }
        
    }
}

/*
 * One pass solution
 */
public class Solution {
    public void sortColors(int[] A) {
        if(A.length == 0)
            return;

        //end of area 0, runner, end of area 1
        int end0 = 0, runner = 0, end1 = A.length - 1;
        
        while(runner <= end1){
            
            int current = A[runner];
            if(current == 0)
                swap(A, end0++, runner++);
            else if(current == 1)
                runner++;
            else
                swap(A, runner, end1--);  //runner shouldn't increase at here
        }
        
    }
    
    //swap function
    public void swap(int[] A, int i, int j){
        if(i == j)
            return;
            
        int temp = 0;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}