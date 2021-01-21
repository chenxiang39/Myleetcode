public class Minesweeper_529_need_review {
    //dfs
    public char[][] updateBoard(char[][] board, int[] click) {
        int y = click[0];
        int x = click[1];
        //direct meet mines
        if(board[y][x] == 'M'){
            board[y][x] = 'X';
        }
        else{
            //need reveal digit directly
            if(aroundHaveMines(y,x,board) != 0){
                board[y][x] = (char)(aroundHaveMines(y,x,board) + '0'); //https://blog.csdn.net/lenfranky/article/details/89639320
            }
            //meet 'B'
            else{
                dfs(y,x,board);
            }
        }
        return board;
    }
    public void dfs(int y, int x, char[][] board){
        //out of range or meet not a unreveal Empty Square
        if(x < 0 || x >= board[0].length || y < 0 || y >= board.length || board[y][x] != 'E'){
            return;
        }
        //meet digit,reveal it and return(stop)
        if(aroundHaveMines(y,x,board) != 0){
            board[y][x] = (char)(aroundHaveMines(y,x,board) + '0');
            return;
        }
        //Blank square
        board[y][x] = 'B';
        //eight directions dfs
        dfs(y - 1, x - 1, board);
        dfs(y - 1, x, board);
        dfs(y - 1, x + 1, board);
        dfs(y, x - 1, board);
        dfs(y, x + 1, board);
        dfs(y + 1, x - 1, board);
        dfs(y + 1, x, board);
        dfs(y + 1, x + 1, board);
    }
    // Search for the number of mines around
    public int aroundHaveMines(int y, int x, char[][] board){
        int amount = 0;
        if(isMine(y - 1, x - 1, board)){
            amount++;
        }
        if(isMine(y - 1, x,board)){
            amount++;
        }
        if(isMine(y - 1, x + 1,board)){
            amount++;
        }
        if(isMine(y, x - 1,board)){
            amount++;
        }
        if(isMine(y, x + 1,board)){
            amount++;
        }
        if(isMine(y + 1, x - 1,board)){
            amount++;
        }
        if(isMine(y + 1, x, board)){
            amount++;
        }
        if(isMine(y + 1, x + 1,board)){
            amount++;
        }
        return amount;
    }
    //check Whether is Mine
    public boolean isMine(int y, int x, char[][] board){
        //out of range or not 'M'
        if(x < 0 || x >= board[0].length || y < 0 || y >= board.length || board[y][x] != 'M'){
            return false;
        }
        else{
            return true;
        }
    }
}
