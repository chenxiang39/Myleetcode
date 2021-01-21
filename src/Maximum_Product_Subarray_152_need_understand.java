public class Maximum_Product_Subarray_152_need_understand {
    //dp
    //leetcode soluation 2
    //Time complexity: O(nums.length)
    //Space complexity: O(1)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(nums.length == 0){
            return 0;
        }
        int min = nums[0];      //到当前下标可以得到的最小的积（因为有负的值存在，因此最小值乘负值可能会变成最大值）
        int max = nums[0];      //到当前下标可以得到的最大的积
        int result = nums[0];
        for(int i = 1; i < n; i++){
            int minaux = min;
            int maxaxu = max;
            min = Math.min(minaux * nums[i], maxaxu * nums[i]);
            min = Math.min(nums[i], min);
            max = Math.max(minaux * nums[i], maxaxu * nums[i]);
            max = Math.max(nums[i],max);
            result = Math.max(result, max);     //比较每次的max，得出最终的结果
        }
        return result;
    }
}
