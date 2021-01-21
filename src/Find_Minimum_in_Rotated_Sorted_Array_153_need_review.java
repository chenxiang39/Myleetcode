public class Find_Minimum_in_Rotated_Sorted_Array_153_need_review {
    //divide and conquer
    //Time complexity: O(logn), n : the length of nums
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int result = nums[0];
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            //前一段有序(加等号的原因是防止漏算hi - lo等于1的情况，此时mid = lo, 需要再一次遍历)
            //找出前一段的最大值，然后查找后一段
            if(nums[mid] >= nums[lo]){
                result = Math.min(result, nums[lo]);
                lo = mid + 1;
            }
            //后一段有序
            //找出后一段的最大值，然后查找前一段
            else{
                result = Math.min(result, nums[mid]);
                hi = mid - 1;
            }
        }
        return result;
    }
}
