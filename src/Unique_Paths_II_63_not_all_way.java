public class Unique_Paths_II_63_not_all_way {
    //dp，思想类似62题
    //Time Complexity : O(M * N) , M和N表示长方形的长和宽
    //Space Complexity: O(M * N),开辟了dp数组
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0:1;
        for (int i = 0; i < obstacleGrid.length; i++){
            for (int j = 0; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j > 0){
                    dp[i][j] = dp[i][j - 1];        //上边和左边边缘的dp值跟上一个对应方向的dp值一样
                }
                if(j == 0 && i > 0){
                    dp[i][j] = dp[i - 1][j];
                }
                else if(i > 0 && j > 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];         //类似62题
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
