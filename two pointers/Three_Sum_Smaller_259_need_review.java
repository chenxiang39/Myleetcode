import java.util.Arrays;

public class Three_Sum_Smaller_259_need_review {
    //two pointers
    //时间复杂度：O(nums.length ^ 2)
    //空间复杂度：O(1)
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        //固定i
        //start和end代表j和k
        for(int i = 0; i < nums.length - 2; i++){
            //不需要查重，因为是按下标记录计算计算答案的
            // if(i > 0 && nums[i] == nums[i - 1]){
            //     continue;
            // }
            int start = i + 1;
            int end = nums.length - 1;
            int sum = target - nums[i];
            while(start < end){
                //因为排过序了,因此当end指针与start指针已经符合要求了，end指针之前的都符合要求
                if(nums[start] + nums[end] < sum){
                    result += (end - start);
                    //记录完答案后start指针向后
                    start++;
                }
                //不满足要求，说明和太大，end指针后退
                else {
                    end--;
                }
            }
        }
        return result;
    }
}
