public class Max_Consecutive_Ones_II_487_need_review {
    //Slide window
    //leetcode solution 2
    //时间复杂度：O(nums.length)
    //空间复杂度：O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int end = 0;
        int result = 0;
        int zeroCount = 0;
        while(end < nums.length){
            //end指针遍历，遇到0，记录0的数量
            if(nums[end] == 0){
                zeroCount++;
            }
            //当0的数量大于1时,左指针向后推，当左指针遍历到0时，减去0的数量(当减去0的数量之后，使当前范围内的值符合左右区间内0的数量不超过1的要求)并把左指针向后推
            if(zeroCount > 1){
                while(zeroCount > 1){
                    if(nums[start] == 0){
                        zeroCount--;
                    }
                    start++;
                }
            }
            //右指针向后遍历
            end++;
            //每次更新长度
            result = Math.max(result, end - start);
        }
        return result;
    }
}
