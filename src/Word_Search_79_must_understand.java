public class Word_Search_79_must_understand {
    //这道题分析看，就是一个词，在一行出现也是true，一列出现也是true，一行往下拐弯也是true，一行往上拐弯也是true，一列往左拐弯也是true，一列往右拐弯也是true。
    //所以是要考虑到所有可能性，基本思路是使用DFS来对一个起点字母上下左右搜索，看是不是含有给定的Word。
    //还要维护一个visited数组，表示从当前这个元素是否已经被访问过了，过了这一轮visited要回false，因为对于下一个元素，当前这个元素也应该是可以被访问的。
    //时间复杂度：O(N⋅3的L次方), where N is the number of cells in the board and L is the length of the word to be matched.
    public static boolean exist(char[][] board, String word) {
        int n = board[0].length;
        int m = board.length;
        boolean [][] isVis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word,0,i,j,isVis)){       //每个点都出发遍历
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word, int Pos, int row,int col,boolean[][] isVis){
        if(Pos == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1 || isVis[row][col]){       //对于访问过，或者是越界的情况，直接false
            return false;
        }
        if(board[row][col] != word.charAt(Pos)){
            return false;
        }
        else{
            isVis[row][col] = true;
            boolean flag = dfs(board,word,Pos + 1, row - 1, col, isVis)||dfs(board,word,Pos + 1, row + 1, col, isVis)||dfs(board,word,Pos + 1, row , col - 1, isVis)||dfs(board,word,Pos + 1, row, col + 1, isVis); //四个方向进行遍历
            isVis[row][col] = false;        //下一轮恢复
            return flag;
        }
    }
    public static void main(String[] args){
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(exist(board,word));
    }
}
