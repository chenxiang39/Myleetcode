public class Find_Peak_Element_162_need_review {
    //线性探测
    //时间复杂度：O(n);
    //空间复杂度：O(1);
    public int findPeakElement_2(int[] nums) {
        int result = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[result]){
                result = i;
            }
            else{
                return result;
            }
        }
        return result;
    }
    //binary search
    //时间复杂度：O(logn);
    //空间复杂度：O(1);
    //由于题目中提示了要用对数级的时间复杂度，那么我们就要考虑使用类似于二分查找法来缩短时间，由于只是需要找到任意一个峰值，那么我们在确定二分查找折半后中间那个元素后，
    //和紧跟的下一个元素比较下大小，如果大于下一个元素，则说明峰值在前面，如果小于则在后面。这样就可以找到一个峰值了，
    //因为题目要求只要找到一个峰值就行了，并且由于每个值都不同，所以在二分查找一定能找到上坡与下坡（或下坡与上坡）之间的峰值
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        //没有等号，最后lo和hi一定会相等(相等的点即为峰值)，会导致死循环
        while (lo < hi){
            int mid = lo + (hi - lo)/2;
            //峰值在后面（前面是上坡）
            if(nums[mid] < nums[mid + 1]){
                lo = mid + 1;
            }
            //峰值在前面（后面是下坡）
            else{
                hi = mid;
            }
        }
        return lo;
    }
}
