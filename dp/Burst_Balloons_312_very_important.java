public class Burst_Balloons_312_very_important {
    //dp
    //Time complexity: O(n^3), 三次循环
    //Space complexity: O(n^2), dp array
    //https://www.bilibili.com/video/BV1Py4y1r7Zv
    //dp[i][j] 表示戳破下标为i到j的气球能得到的maxCoins
    // 注意边界，比如 i == 0, j == n - 1, i == j
    // i 必须小于等于 j,其他情况默认为0
    //用k表示第k（ i <= k <= j ）个气球是最后被戳破的
    //给nums前面和后面添加1，但是result = dp[0][nums.length - 1];
    //dp[i][j] = max(dp[i][k - 1] + dp[k + 1][j] + nums[k] * nums[i - 1] * nums[j + 1](k最后戳破，乘以i和j边界之外的气球，因为其他气球都被戳破了))

    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            //此处必须i从j往0遍历，因为需要知道后面的结果，才能推出rightSum
            //比如边界i == j, 刚进去时候就能得到，此时leftSum和rightSum都为0，因为 i > j 的情况默认为0，因此，此二维数组一半的数字都是0
            for (int i = j; i >= 0; i--) {
                for (int k = i; k <= j; k++) {
                    int leftSum = k == 0 ? 0 : dp[i][k - 1];
                    int rightSum = k == n - 1 ? 0 : dp[k + 1][j];
                    int left = i == 0 ? 1 : nums[i - 1];
                    int right = j == n - 1 ? 1 : nums[j + 1];
                    dp[i][j] = Math.max(dp[i][j], leftSum + rightSum + nums[k] * left * right);
                }
            }
        }
        return dp[0][n - 1];
    }
}
