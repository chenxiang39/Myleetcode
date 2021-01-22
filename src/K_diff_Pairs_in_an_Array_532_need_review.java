import java.util.Arrays;

public class K_diff_Pairs_in_an_Array_532_need_review {
    //two pointers
    //时间复杂度：O(N * logN),排序， N = nums.length
    //空间复杂度：O(N),排序
    public int findPairs(int[] nums, int k) {
        int result = 0;
        if(nums.length < 2){
            return result;
        }
        //先排序，保证指针搜索的正确，按顺序搜索也保证了不会出现[1,3],[3,1]这样的重复组合
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        while(left < nums.length && right < nums.length){
            //去重
            if(left > 0 && nums[left - 1] == nums[left]){
                left++;
                continue;
            }
            //当出现指针到一起时(可能遇到了许多重复的元素或者k = 0的情况)，把右指针向后保证遍历能继续
            if(left == right){
                right++;
                continue;
            }
            //符合要求时记录答案并将两指针都向后
            if(nums[right] - nums[left] == k){
                result++;
                left++;
                right++;
            }
            //差不够大，右指针向后
            else if(nums[right] - nums[left] < k){
                right++;
            }
            //差太大了，左指针向后
            else{
                left++;
            }
        }
        return result;
    }
}
