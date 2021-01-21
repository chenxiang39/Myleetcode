public class Search_in_Rotated_Sorted_Array_33_not_all_way {
    //Binary search
    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (hi >= lo){       //必须有等于号
            int mid = lo + (hi - lo)/2;
            //此处为出口
            if (nums[mid] == target){
                return mid;
            }
            //如果前一段递增（需要有等号）
            if (nums[lo] <= nums[mid]){
                //target在前一段
                if(target < nums[mid] && target >= nums[lo]){   //边缘都需要有等号
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
            //如果后一段递增
            else {
                //target在后一段
                if(target > nums[mid] && target <= nums[hi]){
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    //重要，寻找pivot点
    public static int findpivot (int[] nums, int lo, int hi){
        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            //二分查找
            if (nums[lo] > nums[mid]) {
                hi = mid - 1;
            } else if (nums[hi] < nums[mid]) {
                lo = mid + 1;
            }
            //如果直接循环进有序列
            if (nums[lo] < nums[mid] && nums[mid] < nums[hi]) {
                //循环列以0开始
                if (lo == 0) {
                    return hi + 1;      //输出循环列之后的第一个
                }
                //循环列以最后结束
                if (hi == nums.length - 1) {
                    return lo;           //输出循环列的第一个
                }
            }
            //最后空间压缩到两个指针合并的情况，谁大，选另一个指针
            if (lo == hi - 1){
                if (nums[hi] > nums[lo]){
                    return lo;
                }
                else {
                    return hi;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {6,7,8,9,10,11,12,13,14,15,1,2,3,4};
        System.out.print(search(nums,15));
    }
}
