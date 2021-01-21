import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_two_90_need_to_understand {
    //类似78题,加了判断重复
    //dfs
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length;i++){
            dfs(result,nums,i,cur,0);
        }
        return result;
    }
    private static void dfs(List<List<Integer>> result, int[] nums, int length, List<Integer> cur,int start){
        if(cur.size() == length){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < nums.length; i++){
            //类似40题
            //与之前计算过的重复大小的元素则略过不操作，i大于start的意思是，遍历到之后发现重复的就不算，如果是开头的，则说明该元素为新元素（即使重复也没关系）
            if(start < i && nums[i] == nums[i - 1]){
                continue;
            }
            cur.add(nums[i]);
            dfs(result,nums,length, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

}
