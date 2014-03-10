/*
 * Key point: the number of all possible BST rooted at a Node n equals
 *            that of rooted at n's left child multiply that of rooted at
 *            n's right child.
 *            for leaf node, the possiblity is only 1
 */
public class Solution {
    public int numTrees(int n) {
        return dfsWorker(1,n);
    }
    
    public int dfsWorker(int start, int end){
        if(start >= end)
            return 1;
        
        int total = 0;
        
        for(int i = start;i <= end;i++){
            total += dfsWorker(start,i-1) * dfsWorker(i+1,end);
        }
        
        return total;
    }
}