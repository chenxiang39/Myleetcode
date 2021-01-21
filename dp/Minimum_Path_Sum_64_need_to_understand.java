public class Minimum_Path_Sum_64_need_to_understand {
    //dp，思想类似62题
    //Time Complexity : O(M * N) , M和N表示长方形的长和宽
    //Space Complexity: O(M * N),开辟了dp数组
    public int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (j > 0 && i == 0){
                    dp[i][j] = grid[i][j] + dp[i][j - 1];       //边缘的dp值是由旁边的值加上本身的值
                    continue;
                }
                if (i > 0 && j == 0){
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }
                else if(i > 0 && j > 0){
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];        //左边和上边取小的加上本身的值得到本身的dp值
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
