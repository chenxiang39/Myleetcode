public class Squares_of_a_Sorted_Array_977_need_review {
    //two pointers
    //leetcode solution 2
    //时间复杂度：O(nums.length)
    //空间复杂度：O(1)
    //因为可能产生负数的平方更大，所以采用双指针（同时也由于nums按升序排序）
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int load = nums.length - 1;     //表示填到result的位置
        int[] result = new int[nums.length];
        while(left <= right){
            //比较绝对值
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[load] = nums[left] * nums[left];
                load--;
                left++;
            }
            else{
                result[load] = nums[right] * nums[right];
                load--;
                right--;
            }
        }
        return result;
    }
}
