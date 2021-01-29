public class Binary_Subarrays_With_Sum_930_need_review {
    //two pointers, slide window
    //时间复杂度：O(A.length)
    //空间复杂度：O(1)
    //遍历数组A，将当前数字加入 sum 中，然后看假如此时 sum 大于S了，则要进行收缩窗口操作，左边界 left 右移，并且 sum 要减去这个移出窗口的数字，当循环退出后，
    //假如此时 sum 小于S了，说明当前没有子数组之和正好等于S，若 sum 等于S了，则结果 res 自增1。
    //此时还需要考虑一种情况，就是当窗口左边有连续0的时候，因为0并不影响 sum，但是却要算作不同的子数组，所以要统计左起连续0的个数，并且加到结果 res 中即可
    public int numSubarraysWithSum(int[] A, int S) {
        int left = 0;
        int sum = 0;
        int result = 0;
        for(int right = 0; right < A.length; right++){
            //增加和
            sum += A[right];
            //必须写在前面，因为通过对左指针的向后推，sum会等于S, result可以继续加
            while(left < right && sum > S){
                sum -= A[left];
                left++;
            }
            if(sum == S){
                result++;
            }
            if(sum < S){
                continue;
            }
            //当窗口左边有连续0的时候，因为0并不影响 sum，但是却要算作不同的子数组，所以要统计左起连续0的个数
            for(int i = left; A[i] == 0 && i < right; i++){
                result++;
            }
        }
        return result;
    }
}
