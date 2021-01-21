public class House_Robber_198_need_to_remember {
    //dp
    //时间复杂度：O(n);       一遍循环
    //空间复杂度：O(n);       dp数组
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];        //保存了到每一次所能达到的偷窃的最大额度
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);        //前前一次的偷窃的最大额加上本次能够偷的值的和与前一次偷窃的最大额的比较,大的作为本次偷窃的最大额
        }
        return dp[nums.length - 1];
    }
}
