public class Unique_Paths_62_need_to_understand {
    //采用动态规划。动态规划要求利用到上一次的结果，是一种特殊的迭代思想，动态规划的关键是要得到递推关系式。
    // 对于本题，到达某一点的路径数等于到达它上一点的路径数与它左边的路径数之和。
    // 也即，起点到点(i, j)的路径总数：dp[i][j] = 起点到点(i, j-1)的总数：dp[i][j-1] + 起点到点(i-1, j)总数：dp[i-1][j]。
    // 于是我们就得到递推关系式：dp[i][j] = dp[i][j-1] + dp[i-1][j]
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for(int i = 0 ;i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0 || j == 0 ){
                    dp[i][j] = 1;           //上边和左边边缘都为1
                }
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];         //上面点的路径和加上左面点的路径和
                }
            }
        }
        return dp[n - 1][m - 1];
    }
    //这种优化是对上述方法空间的一种优化，使得空间复杂度从原来的 O(n*m)下降为 O(n)。
    // 对于起点到点(i,j)的路径总数：ways[j]= 起点到点(i-1, j) 的路径总数：ways[j] + 起点到点(i, j-1)的路径总数 ways[j-1]，
    // 于是我们就得到递推式：ways[j] = ways[j] + ways[j-1]
    public static int uniquePaths_2(int m, int n) {
        int[] ways = new int[n];
        ways[0] = 1;
        for(int i = 0; i < m; i++)          //一行一行算
            for (int j = 1; j < n; j++)
                ways[j] += ways[j-1];
        return ways[n-1];
    }
    public static void main(String[] args){
        System.out.println(uniquePaths_2(4,4));
    }
}
