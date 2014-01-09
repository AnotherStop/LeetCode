/*
 *Key point: making sure how the Pascal's triangle is generated
 *  ArrayList is zero-based index
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(numRows <= 0)
            return result;
        
        //two ArrayList for current row and last row    
        ArrayList<Integer> lastRow = new ArrayList<Integer>();
        ArrayList<Integer> currentRow = new ArrayList<Integer>();
        ArrayList<Integer> temp = null;
        
        //treat first line separately
        lastRow.add(1);
        result.add((ArrayList<Integer>) lastRow.clone());
        
        if(numRows == 1)
            return result;
        
        //start from second line, lineNum is 1-based index
        int lineNum = 2;
        for(lineNum = 2;lineNum <= numRows;lineNum++){
            //add the first '1' to a new row
            currentRow.add(1);
            
            //calculate the middle numbers by adding two numbers on its "shoulder"
            //within every ArrayList, it's zero-based index
            //last row has only lineNum-1 elements
            for(int i = 0;i < lineNum-2;i++){
                currentRow.add(lastRow.get(i) + lastRow.get(i+1));
            }
            
            //add the last '1' to this row
            currentRow.add(1);
            
            result.add((ArrayList<Integer>) currentRow.clone());
            lastRow.clear();
            
            //the current working row becomes last row, new current row should be empty
            temp = lastRow;
            lastRow = currentRow;
            currentRow = temp;
            
        }
        
        return result;
        
    }
}