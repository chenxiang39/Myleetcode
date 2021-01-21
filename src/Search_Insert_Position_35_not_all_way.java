public class Search_Insert_Position_35_not_all_way {
    //Binary Search
    public static int searchInsert(int[] nums, int target) {
        //特殊情况可省略
//        if (nums[0] >= target){
//            return 0;
//        }
//        if(nums[nums.length - 1] < target){
//            return nums.length;
//        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (nums[mid] > target){
                hi = mid - 1;
            }
            //lo处小于等于，是因为插入的位置的规律是前一个数必须比自己小，后面一个数与自己一样大也没关系
            else if(nums[mid] <= target){       //必须为小于等于
                if(nums[mid] == target){        //当查找到的数就是target，此位置适合插入target，即为答案
                    lo = mid;
                    break;
                }
                lo = mid + 1;
            }
        }
        return lo;
    }
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,7));
    }
}
