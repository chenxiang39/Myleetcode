public class Rotate_Array_189_need_review {
    //brute force
    //leetcode solution 1
    //Time complexity: O(n * k), k已经经过取模处理， n : the length of nums
    //Space complexity: O(1)
    //Example 1的效果
    public void rotate_1(int[] nums, int k) {
        //speed up the rotation
        k %= nums.length;
        for(int i = 0; i < k; i++){
            int aux = nums[nums.length - 1];
            for(int j = nums.length - 2; j >= 0; j--){
                nums[j + 1] = nums[j];
            }
            nums[0] = aux;
        }
    }
    //Using Reverse
    //leetcode solution 4
    //Time complexity: O(n)
    //Space complexity: O(1)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        //先把整个数组反转，然后前k个数字做反转，再把剩下的的数字做反转
        reverse(0, nums.length - 1, nums);
        reverse(0,k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }
    private void reverse(int start, int end, int[] nums){
        while(end > start){
            int aux = nums[start];
            nums[start] = nums[end];
            nums[end] = aux;
            end--;
            start++;
        }
    }
}
