public class Remove_Duplicates_from_Sorted_Array_II_80_not_all_way {
    //时间复杂度： O(n), n = nums.length
    //空间复杂度 ：O(1)
    //记录当前有多少个连续数，若小于等于2，则直接写入，若大于2，则只写入最前面的两个数。对数组最后面的数需要进行单独判断
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int count = 1;      //记录连续的数个数
        int start = 0;
        for(int i = 0; i < nums.length;i++){
            if(i > 0 && nums[i - 1] == nums[i]){
                count++;
                if(count > 2){      //大于两次直接跳过
                    continue;
                }
            }
            else{
                count = 1;          //当前数不等于前面的数，重置为1
            }
            nums[start] = nums[i];
            start++;
        }
        return start;
    }
    public static void main(String[] args){
        int[] nums = {1,2,2,2,3,4,5,5};
        System.out.println(removeDuplicates(nums));
    }
}
