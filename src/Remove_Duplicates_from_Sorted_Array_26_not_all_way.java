import java.util.HashSet;
import java.util.Set;

public class Remove_Duplicates_from_Sorted_Array_26_not_all_way {
    //Wrong,but result is right(nums is not changed)
    public static int removeDuplicates(int[] nums) {
        int result = 0;
        int Index = 0;
        Set<Integer> set = new HashSet<>();
        while (Index < nums.length){
            if(!set.contains(nums[Index])){
                set.add(nums[Index]);
                result++;
            }
            Index++;
        }
        return result;
    }
    //two pointer
    public static int removeDuplicates_2(int[] nums) {
        if(nums == null){
            return 0;
        }
        int start = 0;
        for (int end = 1; end < nums.length; end++){
            if (nums[start] != nums[end]){
                start++;
                nums[start] = nums[end];        //在上一个相同的值中的下一个填充新的值，因为排过序，故nums[start]被更新为最大的不同的值
            }
        }
        return start + 1;           //最后需要+1（因为从0开始，第一个相同的值并没有被算上）
    }
    public static void main(String[] args){
        int[] nums = {0,1,1,2,3,4,4};
      System.out.println(removeDuplicates_2(nums));
    }
}
