public class Maximum_Subarray_53_need_to_understand {
    //DP
    public static int maxSubArray(int[] nums) {
        int current = nums[0];
        int result = current;
        for (int i = 1; i < nums.length; i++){
            current = Math.max(nums[i],current+nums[i]);        //推进到nums[i]中的最大值(并非最后的最大值)
            result = Math.max(current,result);
        }
        return result;
    }
    //DP(更易理解)
    public int maxSubArray_2(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];            //每个各自位置所能组成的最大值
        int max = dp[0];
        for(int i = 1; i < nums.length; i++){
            if(dp[i - 1] <= 0){         //如果之前的值小于等于0
                dp[i] = nums[i];        //直接从新的值开始计算
            }
            else{
                dp[i] = nums[i] + dp[i - 1];        //否则加上之前的值
            }
            if(max < dp[i]){
                max = dp[i];                    //找最大
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
