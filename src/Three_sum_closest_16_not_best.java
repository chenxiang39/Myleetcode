import java.lang.reflect.Array;
import java.util.Arrays;

public class Three_sum_closest_16_not_best {
    //Two Pointers,类似Three sum
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if(length == 3){
            return nums[0] + nums[1] + nums[2];
        }
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < length && diff != 0; i++){
            int lo = i + 1, hi = length - 1;
            while (lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff)){       //Math.abs => 取绝对值
                    diff = target - sum;
                }
                if (sum < target){
                    lo++;
                }
                else {
                    hi--;
                }
            }
        }
        return target - diff;
    }
}
