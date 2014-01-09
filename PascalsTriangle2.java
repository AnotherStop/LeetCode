/*
 *key point: much like the Pascal's Triangle quesion, the only difference
 *  is we don't need to store previous row; just return the last row is enough,
 *  it's even easier than that question.
 *
 *  However, since I didn't realize that my solution for Pascal's Triangle question
 *  already meets the requirment of O(k) extra space. I tried several other methods 
 *  to calculate the kth row directly with the help of combination formula, 
 *  but I was blocked by data type range overflow
 *
 *  The lesson is always making sure the requirements of questions before coding anything
 */

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(rowIndex < 0)
            return result;
        
        //two ArrayList for current row and last row    
        ArrayList<Integer> lastRow = new ArrayList<Integer>();
        ArrayList<Integer> currentRow = new ArrayList<Integer>();
        ArrayList<Integer> temp = null;
        
        //treat first line separately
        lastRow.add(1);
        
        if(rowIndex == 0)
            return lastRow;
        
        //init lastRow as second line    
        lastRow.add(1);    
        if(rowIndex == 1){
            return lastRow;
        }
        
        //start from third line, lineNum is 0-based index
        int lineNum = 2;
        for(lineNum = 2;lineNum <= rowIndex;lineNum++){
            //add the first '1' to a new row
            currentRow.add(1);
            
            //calculate the middle numbers by adding two numbers on its "shoulder"
            //within every ArrayList, it's zero-based index
            //last row has only lineNum-1 elements
            for(int i = 0;i < lineNum-1;i++){
                currentRow.add(lastRow.get(i) + lastRow.get(i+1));
            }
            
            //add the last '1' to this row
            currentRow.add(1);
            
            lastRow.clear();
            
            //the current working row becomes last row, new current row should be empty
            temp = lastRow;
            lastRow = currentRow;
            currentRow = temp;

        }
        
        return lastRow;
    }
}
