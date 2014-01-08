/*
 *Much like the Remove Duplicates from Sorted Array
 *
 *Key point: since every distinct elements and its one duplicate are
 *moved to before, so even there are many duplicates, A[i+1] doesn't
 *necessarily equal to A[i], we must assiagn manually.
 *
 */

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 2)
            return A.length;
        
        //set length to 1
        int len = 1;

        int i= 0;
        int j = i;
        while(i < A.length-1){
            
            int repeatTimes = 0;          
            
            //skip duplicate elements and count the appearance of duplicates
            while(j < A.length-1 && A[i] == A[++j]){
                repeatTimes++;
            }
            
            //reach the end of array
            if(j == A.length -1){
        
                //the last element isn't distince
                if(A[i] == A[j]){
                    A[i+1] = A[j];
                    len++;
                    
                }
                else{// the last element is distinct
                
                    if(repeatTimes > 0){
                        A[i+1] = A[i];
                        A[i+2] = A[j];
                        len+=2; //because the current duplicate and the new founded element
                    }
                    else{
                        A[i+1] = A[j];
                        len++;
                    }
                }
                
                break;
            }
            else{// doesn't reach the end
            
                if(repeatTimes > 0){
                    A[i+1] = A[i];
                    A[i+2] = A[j];
                    i+=2;
                    len+=2;
                }
                else{
                    A[i+1] = A[j];
                    i++;
                    len++;
                }
            }
        }
        
        return len;        
    }
}