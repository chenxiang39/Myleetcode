import java.util.HashMap;

//HashMap 查找几乎为常数级，可以节省时间！
public class Two_sum_1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap HashNum = new HashMap();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++){
            //在检查之后put可以避免重复的冲突（因为第i个并未被添加进HashMap中）
            if (HashNum.containsKey(target - nums[i])){
                answer[0] = (int)HashNum.get(target - nums[i]);
                answer[1] = i;
                break;      //一旦找到就终止循环
            }
            HashNum.put(nums[i],i);
        }
        return answer;
    }
    public static void main(String[] args){
        int[] nums = {3,3,3};
        int target = 6;
        int x[] = twoSum(nums,target);
        for (int i = 0; i < x.length; i++){
            System.out.println(x[i]);
        }
    }
}
