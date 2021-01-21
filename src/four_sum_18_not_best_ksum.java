import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class four_sum_18_not_best_ksum {
    //双循环配合2sum做（Two pointer）
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            //去重跳过
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++){
                //去重跳过
                if(j > i + 1 && nums[j - 1] == nums[j]){
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;
                int targetSum = target - nums[i] - nums[j];
                while (start < end){    //两个不能一样,有四个数
                    //去重跳过
                    if (start > j + 1 && nums[start - 1] == nums[start]){
                        start++;
                        continue;
                    }
                    //去重跳过
                    if (end < nums.length - 1 && nums[end + 1] == nums[end]){
                        end--;
                        continue;
                    }
                    if(nums[start] + nums[end]  < targetSum){
                        start++;
                        continue;
                    }
                    if(nums[start] + nums[end]  > targetSum){
                        end--;
                        continue;
                    }
                    if (nums[start] + nums[end]  == targetSum){
                        List<Integer> r = new ArrayList<>();
                        r.add(nums[i]);
                        r.add(nums[j]);
                        r.add(nums[start]);
                        r.add(nums[end]);
                        result.add(r);
                        start++;
                        end--;
                        continue;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {1,0,-1,0,2,-2};
        int target = 0;
        System.out.println(fourSum(nums,target));
    }
}
