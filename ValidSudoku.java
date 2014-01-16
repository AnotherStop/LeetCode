/*
 * Key point: according to the test case, in this question,
 *    we just need to test whether the unfinished sudoku statisfies
 *    the three rules of sudoku. We don't need to determine whether
 *    it has a solution.
 */

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null)
            return false;
            
        boolean[] flag = new boolean[9];
        
        //test row
        for(int i = 0;i<9;i++){
            resetFlag(flag);
            for(int j = 0;j<9;j++){
                if(board[i][j] == '.')
                    continue;
                int value = board[i][j] - '1';  //0-based index in array
                
                if(flag[value] == false)
                    flag[value] = true;
                else
                    return false;
            }
        }
        
        //test column
        for(int i = 0;i<9;i++){
            resetFlag(flag);
            for(int j = 0;j<9;j++){
                if(board[j][i] == '.')
                    continue;                
                int value = board[j][i] - '1';  //0-based index in array
                
                if(flag[value] == false)
                    flag[value] = true;
                else
                    return false;
            }
        }
        
        //test small 3*3 grid
        for(int row = 0;row<9;row+=3){
            for(int column = 0;column<9;column+=3){
                resetFlag(flag);    //take care of where should we reset flag array
                for(int i = 0;i<9;i++){
                    int x = 3*(row/3) + i/3;
                    int y = 3*(column/3) + i%3; //here it's i%3 rather than i/3
                    if(board[x][y] == '.')
                        continue;                    
                    int value = board[x][y] - '1';  //0-based index in array
                    
                    if(flag[value] == false)
                        flag[value] = true;
                    else
                        return false;
                }
            }
        }
        
        return true;
        
    }
    
    //reset boolean array
    public void resetFlag(boolean[] flag){
        for(int i = 0;i<flag.length;i++)
            flag[i] = false;
    }

}