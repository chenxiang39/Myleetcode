public class Maximal_Square_221_need_review {
    //dp
    //m : 长
    //n : 宽
    //Time complexity: O(m * n)
    //Space complexity: O(m * n)
    public int maximalSquare(char[][] matrix) {
        int h = matrix.length;
        int l = matrix[0].length;
        int maxR = 0;   //最大的正方形的边长
        int[][] dp = new int[h][l]; //到i,j可以组成的正方形的最长边

        //initial condition
        for(int i = 0; i < l; i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
                maxR = Math.max(maxR, dp[0][i]);
            }
        }
        for(int i = 0; i < h; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                maxR = Math.max(maxR, dp[i][0]);
            }
        }

        //递推式,以 matrix[i][j] 为正方形右下角的边长，最多总是比以 matrix[i - 1][j]、matrix[i][j - 1]、matrix[i - 1][j - 1]
        //为右下角的正方形边长中最小的边长大1。这是因为，如果以 matrix[i - 1][j]、matrix[i][j - 1]、matrix[i - 1][j - 1] 为右下角的正方形边长相等，
        //那么加上该点后就可以构成一个更大的正方形。如果它们不相等，那么因为缺失某部分，而无法构成更大正方形，那么只能取3个正方形中最小的一个加1，
        for(int i = 1; i < h; i++){
            for(int j = 1; j < l; j++){
                if(matrix[i][j] == '1'){
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                    maxR = Math.max(maxR, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxR * maxR;
    }
}
