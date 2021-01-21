public class Sudoku_Solver_37_need_understand {
    //https://www.cnblogs.com/springfor/p/3884252.html
    //就是一点点尝试着填数(dfs)，不行的话就回溯，直到都填满就返回。
    //如果对一个格子尝试从0~9都不行，那么说明整个sudoku无解，返回false就好。
    //对整个棋盘所有'.'都填完了，那么就可以返回true了。
    //复杂度看解释
    public void solveSudoku(char[][] board) {
        if(board.length == 0){
            return;
        }
        dfs(board);
    }

    private boolean dfs(char[][] board){
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isVaild(board, i, j, c)) {
                            board[i][j] = c;
                            if (dfs(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;   //尝试失败
                }
            }
        }
        return true;        //全部的.都被填完
    }

    private boolean isVaild(char[][] board, int i, int j, char num){
        //check columns
        for(int col = 0; col < 9; col++){
            if(board[col][j] == num){
                return false;
            }
        }

        //check rows
        for(int row = 0; row < 9; row++){
            if(board[i][row] == num){
                return false;
            }
        }

        //check 3*3 sub-box
        int colstart = i / 3 * 3;
        int rowstart = j / 3 * 3;
        for(int col = colstart; col < colstart + 3; col++){
            for(int row = rowstart; row < rowstart + 3; row++){
                if(board[col][row] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
