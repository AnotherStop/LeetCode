/*
 * Key point: BFS, if a path of 'O's links to one of the boundries, mark all these 'O's as 'D's
 *    then, scan the whole char[][], the remaining 'O's are surrounded by 'X's, mark it as 'X's,
 *    the 'D's are marked as 'O's again since they should be kept
 *
 *    This can be done with DFS; however, the depth of recursive stack are too deep, stackover flow
 *    is inevitable when test case size is big
 */


public class Solution {
    public void solve(char[][] board) {
        //if a 'O' is surrounded by 'X's, the size of char[][] is at least 3x3
        if(board == null || board.length < 3 || board[0].length < 3)
            return;
            
        Queue<Integer> q = new LinkedList<Integer>();
        
        int row = board.length;
        int column = board[0].length;
        
        //start from left boundry and right boundry
        for(int i = 0;i < row;i++){
            bfsWorker(board, q, i, 0);  //left boundry
            bfsWorker(board, q, i, column - 1);  //right boundry
        }
        
        //start from top boundry and bottom boundry
        for(int j = 1;j < column - 1;j++){
            bfsWorker(board, q, 0, j);  //top boundry
            bfsWorker(board, q, row - 1, j);    //bottom boundry
        }
        
        //change value of char[][] accordingly
        for(int i = 0;i<row;i++){
            for(int j = 0;j<column;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'D')
                    board[i][j] = 'O';
            }
        }
    }
    
    
    public void bfsWorker(char[][] board, Queue<Integer> q, int i, int j){
        
        //enqueue current element
        judgeBeforeEnqueue(board, q,i,j);
        
        while(q.isEmpty() == false){
            int temp = q.poll();
            int x = temp / board[0].length; //restore x index
            int y = temp % board[0].length; //restore y index
            
            //test all directions' neighbor and determine whether they can be pu into queue
            judgeBeforeEnqueue(board, q, x+1, y);
            judgeBeforeEnqueue(board, q, x-1, y);
            judgeBeforeEnqueue(board, q, x, y+1);
            judgeBeforeEnqueue(board, q, x, y-1);
        }
    }
    
    public void judgeBeforeEnqueue(char[][] board, Queue<Integer> q, int x, int y){
        
        //the judge in below must be in the judgeBeforeEnqueue() rather than bfsWorker()
        //because only here has danger that out of boundry
        if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] != 'O')
            return;
        
        board[x][y] = 'D';
        //put it into queue
        q.offer(x * board[0].length + y);   //store x and y index together
        return;
    }

}