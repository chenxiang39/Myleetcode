public class Surrounded_Regions_130_very_important_not_all_way {
    //dfs
    //因为从边路探索，所以能连接到边路的O都是合格的O(用#标记)
    //时间复杂度：O(n),n为板的数量，其实为2次遍历整个板，dfs一次，后面转换遍历一次
    //空间复杂度: O(1)
    //bfs思路：https://www.cnblogs.com/springfor/p/3869853.html
    public void solve(char[][] board) {
        int height = board.length;
        if(height == 0){
            return;
        }
        int length = board[0].length;
        //上和下开始进入(包含四个角)
        for(int i = 0 ; i < length; i++){
            dfs(board,0,i,length,height);
            dfs(board,height - 1, i,length,height);
        }
        //从左和右开始进入(未包含四个角)
        for(int j = 1; j < height - 1; j++){
            dfs(board, j, 0,length,height);
            dfs(board, j, length - 1,length,height);
        }
        for(int i = 0; i < height; i++){
            for(int j = 0; j < length; j++){
                if(board[i][j] == '#'){     //将所有标记为#的改成O
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';      //没标记为#的改成X
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j, int length, int height){
        //越界或遇到#和X就停止
        if(i < 0 || i >= height || j < 0 || j >= length || board[i][j] == '#' || board[i][j] == 'X'){
            return;
        }
        //遇到O就改成#
        if(board[i][j] == 'O'){
            board[i][j] = '#';
        }
        //上下左右探索
        dfs(board, i - 1, j,length,height);
        dfs(board, i + 1, j,length,height);
        dfs(board, i, j + 1,length,height);
        dfs(board, i, j - 1,length,height);
    }
}
