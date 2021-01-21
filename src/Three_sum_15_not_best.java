import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://segmentfault.com/a/1190000020461247
public class Three_sum_15_not_best {
    public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> answ = new ArrayList<>();
            Arrays.sort(nums);      //给nums排序
            for (int i = 0 ; i < nums.length; i++){
                if (i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                int start = i + 1;
                int end = nums.length - 1;
                int target = -1 * (nums[i]);
                while (end > start){
                    //以下两个if为去重
                    if (start  - 1 > i&& nums [start - 1] == nums[start]){      //start指针发现与前一个一样时，略过
                        start++;
                        continue;           //所有的continue都不能省略，因为昨晚一个操作之后，要重新开始循环
                    }
                    if (end + 1 < nums.length && nums [end] == nums[end + 1]){  //end指针发现与前一个一样时，略过
                        end--;
                        continue;
                    }
                    //因为排过序，故end越走越小，start越走越大
                    if (nums[start] + nums[end] > target){
                        end --;
                        continue;
                    }
                    if (nums[start] + nums[end] < target){
                        start++;
                        continue;
                    }
                    if (nums[start] + nums[end] == target ){
                        List<Integer> a =  new ArrayList<Integer>();
                        a.add(nums[i]);
                        a.add(nums[start]);
                        a.add(nums[end]);
                        answ.add(a);
                        start++;
                        end--;    //继续的原因在于，后面还有可能的解，因为start会变大，end会变小
                    }
                }
            }
            return answ;
        }
    public static void main(String[] args){
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(nums));
    }
}
