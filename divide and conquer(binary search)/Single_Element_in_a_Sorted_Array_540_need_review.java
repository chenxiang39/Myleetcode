public class Single_Element_in_a_Sorted_Array_540_need_review {
    //binary search
    //https://www.cnblogs.com/grandyang/p/7679036.html
    //如果当前数字出现两次的话，我们可以通过mid的位置(奇或偶，因为题目的要求，总数组的长度必定为奇数)，
    //如果是mid是奇数下标（说明此元素前面有奇数个元素）（如果当前mid元素与其之后的元素相等），说明落单数左半边，反之则在右半边。
    //时间复杂度： O(logN), N = nums.length
    //空间复杂度： O(1)
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;   //此处 - 1是因为当nums.length为3时，mid + 1会越界,可以选择 - 1因为可以扫描到全部元素
        //不相等是因为出了这个while循环后，lo与hi将会相等
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            boolean isEven = mid % 2 == 0 ? true : false;
            if(nums[mid] == nums[mid + 1]){
                if(isEven){
                    lo = mid + 1;
                }
                else{
                    hi = mid;
                }
            }
            else{
                if(isEven){
                    hi = mid;
                }
                else{
                    lo = mid + 1;
                }
            }
        }
        return nums[lo];
    }
}
