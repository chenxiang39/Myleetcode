public class Subarray_Product_Less_Than_K_713_need_review {
    //two pointers,slide window
    //leetcode solution 2
    //时间复杂度：O(N)
    //空间复杂度：O(1)
    //N: nums.length
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //k = 0或1(nums里面全部是1)会让之后左指针移动越界
        if(k <= 1){
            return 0;
        }
        int left = 0;
        int result = 0;
        //初始乘积
        int prod = 1;
        for(int right = 0; right < nums.length; right++){
            //先乘遍历的右指针
            prod *= nums[right];
            //如果乘积大于等于k的话，将left向后移
            while(prod >= k){
                prod /= nums[left];
                left++;
            }
            //统计结果
            result += right - left + 1;
        }
        return result;
    }
}
