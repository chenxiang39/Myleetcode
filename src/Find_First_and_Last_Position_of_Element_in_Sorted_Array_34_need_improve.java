public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34_need_improve {
    //my way (two pointer) (not best)
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        //双指针找边界
        while (start <= end){
            //确定左边界
            if (nums[start] < target){
                start++;
                continue;
            }
            //确定右边界
            if(nums[end] > target){
                end--;
                continue;
            }
            //都确定完了结束循环
            break;
        }
        //如果越界了，则表示数组中不存在target
        if (end < start){
            start = -1;
            end = -1;
        }
        result[0] = start;
        result[1] = end;
        return result;
    }
    public static void main(String[] args){
        int[] nums = {6};
        int[] result = searchRange(nums,6);
        for (int c : result){
            System.out.println(c);
        }
    }
}
