/*
 *Key point: reducing running time by skipping duplicate elements when move runners.
*/

import java.util.Random;
import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //quicksort(num,0,num.length-1);
        Arrays.sort(num);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        int i=0;
        int j,k,sumthree;
        while(i<num.length-2 && num[i] <= 0){
            j = i+1;
            k = num.length-1;
            while(j<k){
                sumthree = num[i]+num[j]+num[k];
                if(sumthree==0){
                    ArrayList<Integer> temp = new ArrayList<Integer> ();
                    temp.add(num[i]);
                    temp.add(num[j]);
                    temp.add(num[k]);
                    
                    if(!result.contains(temp))
                        result.add(temp);
                    
                    //skip duplicate elements    
                    while (j < num.length - 1 && num[j] == num[++j]);
                    while (k > j && num[k] == num[--k]);
                }
                else if(sumthree < 0){
                    //skip duplicate elements
                    while (j < num.length - 1 && num[j] == num[++j]);
                }
                else{
                    //skip duplicate elements
                    while (k > j && num[k] == num[--k]);
                }
            }
            //skip duplicate elements
            while (i < num.length - 2 && num[i] == num[++i]);
        }
        return result;
}

/*implementing quicksort by myself*/    
    public void quicksort(int[] arr, int p, int r){
        if(p<r){
            int q = partition(arr, p ,r);
            quicksort(arr,p,q-1);
            quicksort(arr,q+1,r);
        }
    }
    
    public void swap(int[] arr, int a, int b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
    }
    
    public int partition(int[] arr, int p, int r){
        Random rand = new Random();
        int rnum = rand.nextInt(r-p+1)+p;
        swap(arr,rnum,r);

        int pivot = arr[r];
        int i = p - 1;
        int j = p;
        for(j = p;j<r;j++){
            if(arr[j]<=pivot){
                    i++;
                    swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }
}