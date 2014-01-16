/*
 * Key point: dfs
 *
 * Lesson: Array is object, so it's name is a reference
 */

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null)
            return;
        
        //gather all empty cells together   
        ArrayList<Integer> emptyCell = new ArrayList<Integer>();    
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == '.')
                    emptyCell.add(i*9+j);   //store i and j index together
            }
        }
        
        dfsWorker(board, emptyCell, 0);
    }
    
    public boolean dfsWorker(char[][] board, ArrayList<Integer> emptyCell, int current){
        if(current == emptyCell.size())
            return true;
        
        //get row and column index
        int temp = emptyCell.get(current);
        int row = temp/9;
        int column = temp%9;
        
        //try every possible value
        for(int value = 1;value<=9;value++){
            //test whether the value is valid
            if(isValid(value, row, column, board)){
                //if valid, fill it to board
                board[row][column] = (char) (value+'0');
                //work on next empty cell
                if(dfsWorker(board, emptyCell, current+1))
                    return true;
                
                //recover to empty cell before try other value
                //otherwise, we can't the whether the value is provided originally
                //or it's filled by us    
                board[row][column] = '.';
            }
        }
        
        return false;
    }
    
    public boolean isValid(int value, int row, int column, char[][] board){
        for(int i = 0;i<9;i++){
            if(board[row][i] - '0' == value)
                return false;
            if(board[i][column] - '0' == value)
                return false;
            
            //check validation for small 3x3 grid    
            int x = 3*(row/3) + i/3;    //row index of 3x3 grid
            int y = 3*(column/3) + i%3; //column index of 3x3 grid
            if(board[x][y] - '0' == value)
                return false;
        }
        
        return true;
    }
}